package edu.fst.m2.ipii.carpooling.service;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;

import edu.fst.m2.ipii.carpooling.transverse.dto.MembreDto;
import edu.fst.m2.ipii.carpooling.transverse.dto.VoitureDto;

/**
 * Created by Dimitri on 02/04/15.
 */
public interface MembreService {

    List<MembreDto> rechercher();

    MembreDto rechercher(int id);

    MembreDto rechercher(String login);

    MembreDto rechercher(String login, String password);
    
    void save(MembreDto membre);
    
    void update(MembreDto membreDto);

    List<VoitureDto> rechercherVoitures(int membreId);

    void nouveau(MembreDto membreDto);

}
