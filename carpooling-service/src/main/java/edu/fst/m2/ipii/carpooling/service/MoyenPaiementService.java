package edu.fst.m2.ipii.carpooling.service;

import edu.fst.m2.ipii.carpooling.domaine.bo.MoyenPaiement;
import edu.fst.m2.ipii.carpooling.transverse.dto.MembreDto;
import edu.fst.m2.ipii.carpooling.transverse.dto.MoyenPaiementDto;

import java.util.List;

/**
 * Created by Dimitri on 05/04/15.
 */
public interface MoyenPaiementService {

    List<MoyenPaiementDto> lister();

    MoyenPaiementDto rechercher(int id);

}
