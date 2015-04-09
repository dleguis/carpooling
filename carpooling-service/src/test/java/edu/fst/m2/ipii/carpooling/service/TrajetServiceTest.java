package edu.fst.m2.ipii.carpooling.service;

import edu.fst.m2.ipii.carpooling.transverse.constants.EtatReservation;
import edu.fst.m2.ipii.carpooling.transverse.criteria.TrajetCriteria;
import edu.fst.m2.ipii.carpooling.transverse.dto.*;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TrajetServiceTest extends AbstractServiceTest {

    @Test
    public void testRechercher() throws Exception {
        Set<TrajetDto> trajets = trajetService.rechercher(TrajetCriteria.builder()
                .villeDepart("Lille")
                .villeArrivee("Paris")
                .dateDepart(DateTime.parse("31/12/2015", DateTimeFormat.forPattern("dd/MM/YYYY")).toDate())
                .build());

        assertNotNull(trajets);
    }

    @Test
    public void testRechercherUn() throws Exception {
        TrajetDto trajet = trajetService.getTrajet(1);

        assertNotNull(trajet);

    }

    @Test
    @Transactional
    @Rollback(true)
    public void testCreer() throws Exception {

        Date dateExecution = DateTime.parse("05/04/2015", DateTimeFormat.forPattern("dd/MM/YYYY")).toDate();

        // Paiement
        PaiementDto paiement = new PaiementDto();
        paiement.setSomme(0);
        paiement.setMoyenPaiement(moyenPaiementService.rechercher(1));

        // Facture
        FactureDto facture = new FactureDto();
        facture.setPaiement(paiement);
        facture.setDateFacture(dateExecution);

        // Points embarquement
        PointEmbarquementDto depart = new PointEmbarquementDto(); // Lille
        depart.setLatitude(50.62925);
        depart.setLongitude(3.057256);

        PointEmbarquementDto arrivee = new PointEmbarquementDto(); // Paris
        depart.setLatitude(48.856614);
        depart.setLongitude(2.3522219);

        // Membre
        MembreDto membre = membreService.rechercher(1);

        // Reservation
        ReservationDto reservation = new ReservationDto();
        reservation.setDateReservation(dateExecution);
        reservation.setFacture(facture);
        reservation.setInitiale(true);
        reservation.setMembre(membre);
        reservation.setNombrePassagers(1);
        reservation.setTarif(12F);
        reservation.setPointEmbarquement(depart);
        reservation.setEtat(EtatReservation.INITIALE);

        // Trajet
        TrajetDto trajet = new TrajetDto();
        trajet.setArrivee(arrivee);
        trajet.setTitre("Voyage de test");
        trajet.setVoiture(membre.getVoitures().get(0));
        trajet.getReservations().add(reservation);

        TrajetDto trajetCree = trajetService.getTrajet(trajetService.creer(trajet));

        assertNotNull(trajetCree);

    }
}