package edu.fst.m2.ipii.carpooling.service.impl;

import edu.fst.m2.ipii.carpooling.domaine.bo.Membre;
import edu.fst.m2.ipii.carpooling.service.MembreService;
import edu.fst.m2.ipii.carpooling.transverse.dto.MembreDto;
import edu.fst.m2.ipii.carpooling.transverse.utils.mapper.MapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dimitri on 02/04/15.
 */
@Service
public class MembreServiceImpl extends AbstractServiceImpl implements MembreService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MembreServiceImpl.class);

    @Override
    public List<MembreDto> rechercher() {
        List<Membre> membres = membreRepository.findAll();
        for(Membre membre : membres) {
            LOGGER.debug("profils : {}", membre.getProfils());
        }
        return MapperUtils.map(mapperService, membres, MembreDto.class);
    }

    @Override
    public MembreDto rechercher(int id) {
        Membre membre = membreRepository.findOne(id);

        LOGGER.debug("profils : {}", membre.getProfils());
        LOGGER.debug("voitures : {}", membre.getVoitures());

        return MapperUtils.map(mapperService, membre, MembreDto.class);
    }

    @Override
    public MembreDto rechercher(String login) {
        Membre membre = membreRepository.findByLogin(login);

        LOGGER.debug("profils : {}", membre.getProfils());
        LOGGER.debug("voitures : {}", membre.getVoitures());

        return MapperUtils.map(mapperService, membre, MembreDto.class);
    }
}