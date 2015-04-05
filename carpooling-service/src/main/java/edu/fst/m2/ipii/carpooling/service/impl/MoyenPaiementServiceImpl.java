package edu.fst.m2.ipii.carpooling.service.impl;

import edu.fst.m2.ipii.carpooling.domaine.bo.Membre;
import edu.fst.m2.ipii.carpooling.service.MembreService;
import edu.fst.m2.ipii.carpooling.service.MoyenPaiementService;
import edu.fst.m2.ipii.carpooling.transverse.dto.MembreDto;
import edu.fst.m2.ipii.carpooling.transverse.dto.MoyenPaiementDto;
import edu.fst.m2.ipii.carpooling.transverse.utils.mapper.MapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dimitri on 02/04/15.
 */
@Service
public class MoyenPaiementServiceImpl extends AbstractServiceImpl implements MoyenPaiementService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MoyenPaiementServiceImpl.class);


    @Override
    public List<MoyenPaiementDto> lister() {
        return MapperUtils.map(mapperService, moyenPaiementRepository.findAll(), MoyenPaiementDto.class);
    }

    @Override
    public MoyenPaiementDto rechercher(int id) {
        return MapperUtils.map(mapperService, moyenPaiementRepository.findOne(id), MoyenPaiementDto.class);
    }
}