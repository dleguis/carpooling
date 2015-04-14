package edu.fst.m2.ipii.carpooling.service.impl;

import edu.fst.m2.ipii.carpooling.domaine.bo.Membre;
import edu.fst.m2.ipii.carpooling.domaine.bo.Trajet;
import edu.fst.m2.ipii.carpooling.domaine.bo.Voiture;
import edu.fst.m2.ipii.carpooling.service.VoitureService;
import edu.fst.m2.ipii.carpooling.transverse.dto.VoitureDto;
import edu.fst.m2.ipii.carpooling.transverse.exception.CarpoolingFonctionnelleException;
import edu.fst.m2.ipii.carpooling.transverse.exception.code.CarpoolingFonctionnelleExceptionCode;
import edu.fst.m2.ipii.carpooling.transverse.utils.mapper.MapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Dimitri on 14/04/2015.
 */
@Service
public class VoitureServiceImpl extends AbstractServiceImpl implements VoitureService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VoitureServiceImpl.class);

    @Override
    public List<VoitureDto> rechercher() {
        return MapperUtils.map(mapperService, voitureRepository.findAll(), VoitureDto.class);
    }

    @Override
    public VoitureDto rechercher(int voitureId) {

        Voiture voiture = voitureRepository.findOne(voitureId);

        if (null == voiture) {
            throw new CarpoolingFonctionnelleException(CarpoolingFonctionnelleExceptionCode.ERR_VOITURE_001);
        }

        return MapperUtils.map(mapperService, voiture, VoitureDto.class);
    }

    @Override
    public List<VoitureDto> rechercherParMembre(int membreId) {
        return MapperUtils.map(mapperService, voitureRepository.findByConducteur(membreId), VoitureDto.class);
    }

    @Override
    public void creer(VoitureDto voiture, int membreId) {
        Voiture v = MapperUtils.map(mapperService, voiture, Voiture.class);

        Membre m = membreRepository.findOne(membreId);

        v.setProprietaire(m);

        voitureRepository.save(v);
    }

    @Override
    public void supprimerVoiture(int voitureId, int membreId) {
        Voiture voiture = voitureRepository.findOne(voitureId);

        if (null == voiture) {
            throw new CarpoolingFonctionnelleException(CarpoolingFonctionnelleExceptionCode.ERR_VOITURE_001);
        }
        else if (voiture.getProprietaire().getID() != membreId) {
            throw new CarpoolingFonctionnelleException(CarpoolingFonctionnelleExceptionCode.ERR_VOITURE_002);
        }

        supprimerVoiture(voiture);
    }

    @Override
    public void supprimerVoiture(Voiture voiture) {

        List<Trajet> trajets = trajetRepository.findByVoiture(voiture.getID());

        LOGGER.debug("trajets : {}", trajets);

        // Notification des éventuels passagers
        for (Trajet trajet : trajets) {
            for (Membre membre : trajet.getMembresPassagers()) {
                emailService.envoyer("Dogecar<noreply@dogecar.com>",
                        membre.getEmail(),
                        "Annulation de votre trajet",
                        "Bonjour " + membre.getPrenomMembre() +
                                ", \n\n Votre trajet " + trajet.getTitre() +
                                " du " + trajet.getDateDepart() +
                                " vient d'être annulé. \n\n Cordialement.");
            }
        }

        trajetRepository.delete(trajets);
        voitureRepository.delete(voiture);
    }


}
