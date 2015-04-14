package edu.fst.m2.ipii.carpooling.presentation;


import edu.fst.m2.ipii.carpooling.service.*;
import edu.fst.m2.ipii.carpooling.transverse.dto.Utilisateur;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by Dimitri on 16/11/14.
 */
public abstract class AbstractController {

    /**
     * The Constant LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractController.class);

    @Autowired
    protected TrajetService trajetService;

    @Autowired
    protected MembreService membreService;

    @Autowired
    protected MoyenPaiementService moyenPaiementService;

    @Autowired
    protected ReservationService reservationService;

    @Autowired
    protected VoitureService voitureService;

    /**
     * Gets the user profil.
     *
     * @return the user profil
     */
    @ModelAttribute("userProfil")
    public Utilisateur getUserProfil() {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        if (!(a.getPrincipal() instanceof Utilisateur)) {
            return null;
        }
        return (Utilisateur) a.getPrincipal();
    }


}
