package edu.fst.m2.ipii.carpooling.service;

import edu.fst.m2.ipii.carpooling.transverse.dto.MembreDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dimitri on 02/04/15.
 */
public interface MembreService {

    List<MembreDto> rechercher();

    MembreDto rechercher(int id);

    MembreDto rechercher(String login);
}
