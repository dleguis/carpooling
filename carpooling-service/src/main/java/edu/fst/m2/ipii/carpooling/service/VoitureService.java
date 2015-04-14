package edu.fst.m2.ipii.carpooling.service;

import edu.fst.m2.ipii.carpooling.domaine.bo.Voiture;
import edu.fst.m2.ipii.carpooling.transverse.dto.VoitureDto;

import java.util.List;

/**
 * Created by Dimitri on 14/04/2015.
 */
public interface VoitureService {

    List<VoitureDto> rechercher();

    VoitureDto rechercher(int voitureId);

    List<VoitureDto> rechercherParMembre(int membreId);

    void creer(VoitureDto voiture, int membreId);

    void supprimerVoiture(int voitureId, int membreId);

    void supprimerVoiture(Voiture voiture);
}
