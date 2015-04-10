package edu.fst.m2.ipii.carpooling.service.impl;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import edu.fst.m2.ipii.carpooling.domaine.bo.*;
import edu.fst.m2.ipii.carpooling.service.TrajetService;
import edu.fst.m2.ipii.carpooling.transverse.constants.EtatReservation;
import edu.fst.m2.ipii.carpooling.transverse.criteria.TrajetCriteria;
import edu.fst.m2.ipii.carpooling.transverse.dto.*;
import edu.fst.m2.ipii.carpooling.transverse.exception.CarpoolingFonctionnelleException;
import edu.fst.m2.ipii.carpooling.transverse.exception.code.CarpoolingFonctionnelleExceptionCode;
import edu.fst.m2.ipii.carpooling.transverse.utils.mapper.MapperUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Dimitri on 05/04/15.
 */
@Service
@Transactional
public class TrajetServiceImpl extends AbstractServiceImpl implements TrajetService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrajetServiceImpl.class);

    private Map<String, CoordonneesVilleDto> cacheCoordonnees = new HashMap<>();

    @Override
    public List<TrajetDto> rechercher() {
        return MapperUtils.map(mapperService, trajetRepository.findAllActif(), TrajetDto.class);
    }

    @Override
    public Set<TrajetDto> rechercher(TrajetCriteria trajetCriteria) throws Exception {

        CoordonneesVilleDto coordonneesDepart;
        CoordonneesVilleDto coordonneesArrivee;

        try {
            // Récupération des coordonnées de la ville de départ
            coordonneesDepart = getCoordonneesByRequest(trajetCriteria.getVilleDepart());
            // Récupération des coordonnées de la ville d'arrivée
            coordonneesArrivee = getCoordonneesByRequest(trajetCriteria.getVilleArrivee());
        }
        catch (Exception exception) {
            return new HashSet<>();
        }

        Set<Trajet> trajets;

        if (trajetCriteria.getDateDepart() == null) {
            trajets = trajetRepository.findTrajetByCriteriaAlt(
                    coordonneesDepart.getLatitude(),
                    coordonneesDepart.getLongitude(),
                    coordonneesArrivee.getLatitude(),
                    coordonneesArrivee.getLongitude());
        }
        else {
            trajets = trajetRepository.findTrajetByCriteria(
                    coordonneesDepart.getLatitude(),
                    coordonneesDepart.getLongitude(),
                    coordonneesArrivee.getLatitude(),
                    coordonneesArrivee.getLongitude(),
                    new DateTime(trajetCriteria.getDateDepart()).withTimeAtStartOfDay().toDate(),
                    new DateTime(trajetCriteria.getDateDepart()).withTime(23, 59, 59, 0).toDate()
            );
        }

        return MapperUtils.map(mapperService, trajets, TrajetDto.class);
    }

    @Override
    public TrajetDto getTrajet(int id) {

        Trajet trajet = trajetRepository.findOneFetch(id);

        if (null == trajet) {
            throw new CarpoolingFonctionnelleException(CarpoolingFonctionnelleExceptionCode.ERR_TRAJET_002);
        }

        // LOGGER.debug("réservations : {}", trajet.getReservations());

        LOGGER.debug("places disponibles : {}", trajet.getNbPlacesDisponibles());

        return MapperUtils.map(mapperService, trajet, TrajetDto.class);
    }

    @Override
    public int creer(TrajetDto trajetDto) throws Exception {

        Trajet trajet = MapperUtils.map(mapperService, trajetDto, Trajet.class);
        trajet.setActif(true);

        CoordonneesVilleDto coordonnees = getCoordonneesByRequest(trajet.getArrivee().getLibelle());
        trajet.getArrivee().setLatitude(coordonnees.getLatitude());
        trajet.getArrivee().setLongitude(coordonnees.getLongitude());
        // Sauvegarde préalable du point d'embarquement d'arrivée du trajet
        trajet.setArrivee(pointEmbarquementRepository.save(trajet.getArrivee()));


        List<Reservation> reservations = MapperUtils.map(mapperService, trajetDto.getReservations(), Reservation.class);


        reservations.get(0).getFacture().getPaiement().setMoyenPaiement(moyenPaiementRepository.findOne(1));

        paiementRepository.save(reservations.get(0).getFacture().getPaiement());

        factureRepository.save(reservations.get(0).getFacture());



        // récupération de la voiture associée
        trajet.setVoiture(voitureRepository.findOne(trajetDto.getVoiture().getID()));

        // Sauvegarde du trajet
        trajet = trajetRepository.save(trajet);

        PointEmbarquement pt = reservations.get(0).getPointEmbarquement();

        reservations.get(0).setMembre(membreRepository.findByLogin(reservations.get(0).getMembre().getLogin()));
        reservations.get(0).setTrajet(trajet);
        // Création de la réservation initiale
        reservations = reservationRepository.save(reservations);

        coordonnees = getCoordonneesByRequest(reservations.get(0).getPointEmbarquement().getLibelle());
        pt.setLatitude(coordonnees.getLatitude());
        pt.setLongitude(coordonnees.getLongitude());
        pt.setLibelle(coordonnees.getRequest());
        pt.setReservation(reservations.get(0));

        pointEmbarquementRepository.save(pt);

        trajet.getReservations().clear();
        trajet.getReservations().addAll(reservations);

        // Récupération de l'id du trajet nouvellement créé
        return trajet.getID();
    }

    @Override
    public void reserver(NouvelleReservationDto nouvelleReservation) throws Exception {
        Trajet trajet = trajetRepository.findOne(nouvelleReservation.getTrajetId());

        if (trajet == null) {
            throw new CarpoolingFonctionnelleException(CarpoolingFonctionnelleExceptionCode.ERR_TRAJET_002);
        }
        else if (trajet.getNbPlacesDisponibles() - nouvelleReservation.getNbPlaces() < 0) {
            throw new CarpoolingFonctionnelleException(CarpoolingFonctionnelleExceptionCode.ERR_TRAJET_003);
        }

        CoordonneesVilleDto coordonnees = getCoordonneesByRequest(nouvelleReservation.getPointEmbarquement());

        Paiement paiement = new Paiement();
        paiement.setMoyenPaiement(moyenPaiementRepository.findOne(nouvelleReservation.getMoyenPaiementId()));
        paiement.setSomme(trajet.getTarif());

        paiement = paiementRepository.save(paiement);

        Facture facture = new Facture();
        facture.setDateFacture(DateTime.now().toDate());
        facture.setPaiement(paiement);

        facture = factureRepository.save(facture);


        Reservation reservation = new Reservation();
        reservation.setNombrePassagers(nouvelleReservation.getNbPlaces());
        reservation.setDateReservation(DateTime.now().toDate());
        reservation.setFacture(facture);
        reservation.setInitiale(false);
        reservation.setMembre(membreRepository.findOne(nouvelleReservation.getMembreId()));
        reservation.setEtat(EtatReservation.EN_ATTENTE);
        reservation.setTrajet(trajet);
        reservation.setTarif(new Float(trajet.getTarif()));

        reservation = reservationRepository.save(reservation);

        PointEmbarquement pointDepart = new PointEmbarquement();
        pointDepart.setLibelle(coordonnees.getRequest());
        pointDepart.setLatitude(coordonnees.getLatitude());
        pointDepart.setLongitude(coordonnees.getLongitude());
        pointDepart.setReservation(reservation);

        pointEmbarquementRepository.save(pointDepart);
    }

    @Override
    public void annuler(int trajetId, String username) {
        Trajet trajet = trajetRepository.findOne(trajetId);

        if (null == trajet || !username.equals(trajet.getConducteur())) {
            throw new CarpoolingFonctionnelleException(CarpoolingFonctionnelleExceptionCode.ERR_TRAJET_002);
        }

        for (Reservation reservation : trajet.getReservations()) {
            reservation.setEtat(EtatReservation.ANNULEE);
        }

        trajet.setActif(false);

        trajetRepository.save(trajet);
    }

    @Override
    public List<TrajetDto> rechercherParMembreId(int membreId) {

        return MapperUtils.map(mapperService, reservationRepository.findByConducteur(membreId, EtatReservation.INITIALE), TrajetDto.class);
    }

    @Override
    public List<TrajetDto> rechercherParPassagerId(int membreId) {
        return MapperUtils.map(mapperService, reservationRepository.findByPassager(membreId), TrajetDto.class);
    }

    @Override
    public List<ReservationDto> rechercherReservationsEnAttente(int trajetId) {
        return MapperUtils.map(mapperService, trajetRepository.findAllReservationsEnAttente(trajetId), ReservationDto.class);
    }



    // @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
    // @Cacheable(cacheName = "getCoordonneesCache")
    private CoordonneesVilleDto getCoordonneesByRequest(String request) throws Exception{

        if (cacheCoordonnees.containsKey(request)) {
            CoordonneesVilleDto coordonnees = cacheCoordonnees.get(request);

            // Max 10 000 éléments dans le cache
            if (cacheCoordonnees.size() > 10000) {
                cacheCoordonnees.clear();
            }

            return coordonnees;
        }

        CoordonneesVilleDto coordonnees = new CoordonneesVilleDto();

        GeoApiContext context = new GeoApiContext().setApiKey("***REMOVED***");
        GeocodingResult[] results =  GeocodingApi.geocode(context, request).await();

        coordonnees.setRequest(request);
        coordonnees.setLatitude(results[0].geometry.location.lat);
        coordonnees.setLongitude(results[0].geometry.location.lng);

        coordonnees.setRue((results[0].addressComponents.length > 0 ? results[0].addressComponents[0].longName : null) + " " + (results[0].addressComponents[1] != null ? results[0].addressComponents[1].longName : null));
        coordonnees.setVille(results[0].addressComponents.length > 2 ? results[0].addressComponents[2].longName : null);
        coordonnees.setCodePostal(results[0].addressComponents.length > 6 ? results[0].addressComponents[6].longName : null);
        coordonnees.setPays(results[0].addressComponents.length > 5 ? results[0].addressComponents[5].longName : null);

        cacheCoordonnees.put(request, coordonnees);

        return coordonnees;
    }
}
