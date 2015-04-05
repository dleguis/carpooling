package edu.fst.m2.ipii.carpooling.service;

import edu.fst.m2.ipii.carpooling.transverse.criteria.TrajetCriteria;
import edu.fst.m2.ipii.carpooling.transverse.dto.TrajetDto;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TrajetServiceTest extends AbstractServiceTest {

    @Test
    public void testRechercher() throws Exception {
        List<TrajetDto> trajets = trajetService.rechercher(TrajetCriteria.builder()
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
}