package edu.fst.m2.ipii.carpooling.service.impl;

import edu.fst.m2.ipii.carpooling.service.MembreService;
import edu.fst.m2.ipii.carpooling.transverse.dto.MembreDto;
import edu.fst.m2.ipii.carpooling.transverse.utils.mapper.MapperUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dimitri on 02/04/15.
 */
@Service
public class MembreServiceImpl extends AbstractServiceImpl implements MembreService {

    @Override
    public List<MembreDto> rechercher() {
        return MapperUtils.map(mapperService, membreRepository.findAll(), MembreDto.class);
    }
}