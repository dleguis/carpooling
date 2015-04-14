package edu.fst.m2.ipii.carpooling.service;

import edu.fst.m2.ipii.carpooling.transverse.constants.Carburant;
import edu.fst.m2.ipii.carpooling.transverse.constants.CategorieEnum;
import edu.fst.m2.ipii.carpooling.transverse.constants.EtatReservation;
import edu.fst.m2.ipii.carpooling.transverse.criteria.TrajetCriteria;
import edu.fst.m2.ipii.carpooling.transverse.dto.*;
import org.apache.commons.collections.CollectionUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class VoitureServiceTest extends AbstractServiceTest {

    @Test
    public void testRechercher() throws Exception {
        List<VoitureDto> voitures = voitureService.rechercher();

        assertNotNull(voitures);
        assertTrue(CollectionUtils.size(voitures) > 0);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testCreer() throws Exception {

        VoitureDto voiture = new VoitureDto();

        voiture.setMarque("Marque Test");
        voiture.setModele("Modele test");
        voiture.setNbPlaces(8);
        voiture.setPuissance(135F);
        voiture.setCarburant(Carburant.DIESEL);
        voiture.setCategorie(CategorieEnum.MINIBUS);

        voitureService.creer(voiture, 1);

    }

    @Test
    @Transactional
    @Rollback(true)
    public void testSupprimer() throws Exception {

        voitureService.supprimerVoiture(voitureRepository.findOne(1));
        assertNull(voitureService.rechercher(1));

    }

    @Test
    public void testRechercherParMembre() throws Exception {
        List<VoitureDto> voitures = voitureService.rechercherParMembre(1);

        assertNotNull(voitures);
        assertTrue(CollectionUtils.size(voitures) > 0);

    }
}