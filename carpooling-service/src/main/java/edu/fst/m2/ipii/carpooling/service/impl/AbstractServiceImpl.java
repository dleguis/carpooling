package edu.fst.m2.ipii.carpooling.service.impl;

import edu.fst.m2.ipii.carpooling.domaine.repository.MembreRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Projet Bookstore (FST)
 * Créé par Dimitri le 16/11/14.
 */
@Service
@Transactional
public abstract class AbstractServiceImpl {

    @Autowired
    protected MembreRepository membreRepository;

    /** The mapper service. */
    @Autowired
    protected Mapper mapperService;

}