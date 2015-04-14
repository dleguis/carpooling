package edu.fst.m2.ipii.carpooling.service.impl;

import edu.fst.m2.ipii.carpooling.domaine.bo.Facture;
import edu.fst.m2.ipii.carpooling.domaine.repository.*;
import edu.fst.m2.ipii.carpooling.service.EmailService;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractServiceImpl.class);

    @Autowired
    protected MembreRepository membreRepository;

    @Autowired
    protected TrajetRepository trajetRepository;

    @Autowired
    protected ReservationRepository reservationRepository;

    @Autowired
    protected PointEmbarquementRepository pointEmbarquementRepository;

    @Autowired
    protected MoyenPaiementRepository moyenPaiementRepository;

    @Autowired
    protected VoitureRepository voitureRepository;

    @Autowired
    protected PaiementRepository paiementRepository;

    @Autowired
    protected FactureRepository factureRepository;

    @Autowired
    protected ProfilRepository profilRepository;

    @Autowired
    protected EmailService emailService;

    /** The mapper service. */
    @Autowired
    protected Mapper mapperService;

}
