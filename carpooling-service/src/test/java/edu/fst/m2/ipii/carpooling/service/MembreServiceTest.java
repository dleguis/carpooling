package edu.fst.m2.ipii.carpooling.service;

import edu.fst.m2.ipii.carpooling.transverse.dto.MembreDto;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MembreServiceTest extends AbstractServiceTest {

    @Test
    public void testRechercher() throws Exception {

        List<MembreDto> membres = membreService.rechercher();
        assertTrue(membres.size() > 0);
    }
}