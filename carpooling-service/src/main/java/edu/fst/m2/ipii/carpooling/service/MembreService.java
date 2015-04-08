package edu.fst.m2.ipii.carpooling.service;

import java.util.List;

import edu.fst.m2.ipii.carpooling.transverse.dto.MembreDto;

/**
 * Created by Dimitri on 02/04/15.
 */
public interface MembreService {

    List<MembreDto> rechercher();

    MembreDto rechercher(int id);

    MembreDto rechercher(String login);
    
    void save(MembreDto membre);
    
    void update(MembreDto membreDto);
    
    
}
