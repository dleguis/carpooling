package edu.fst.m2.ipii.carpooling.service;

import edu.fst.m2.ipii.carpooling.transverse.constants.EtatReservation;
import edu.fst.m2.ipii.carpooling.transverse.dto.MembreDto;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ReservationServiceTest extends AbstractServiceTest {

    @Test
    public void testGetEtatReservation() throws Exception {

        EtatReservation etatReservation = reservationService.getEtatReservation(1, 1);

        assertNotNull(etatReservation);
        assertEquals(EtatReservation.INITIALE, etatReservation);
    }
}