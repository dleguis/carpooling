package edu.fst.m2.ipii.carpooling.service.auth.impl;


import edu.fst.m2.ipii.carpooling.domaine.bo.Membre;
import edu.fst.m2.ipii.carpooling.domaine.bo.Profil;
import edu.fst.m2.ipii.carpooling.domaine.bo.Role;
import edu.fst.m2.ipii.carpooling.domaine.repository.MembreRepository;
import edu.fst.m2.ipii.carpooling.service.MembreService;
import edu.fst.m2.ipii.carpooling.service.auth.AuthentificationService;
import edu.fst.m2.ipii.carpooling.transverse.dto.MembreDto;
import edu.fst.m2.ipii.carpooling.transverse.dto.ProfilDto;
import edu.fst.m2.ipii.carpooling.transverse.dto.RoleDto;
import edu.fst.m2.ipii.carpooling.transverse.dto.Utilisateur;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dimitri on 02/11/14.
 */
@Service
public class AuthentificationServiceImpl implements AuthentificationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthentificationService.class);

    /**
     * The user repository.
     */
    @Autowired
    private MembreService membreService;

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.core.userdetails.UserDetailsService#
     * loadUserByUsername(java.lang.String)
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

	    MembreDto membre = membreService.rechercher(s);

        if (membre == null) {
            throw new UsernameNotFoundException(String.format("Utilisateur {} introuvable", s));
        }

        Set<GrantedAuthority> authorities = new HashSet<>();
        for (ProfilDto profil : membre.getProfils()) {
            for (RoleDto role : profil.getRoles()) {
                LOGGER.debug("ROLE : {}", role.getID());
                authorities.add(new SimpleGrantedAuthority(role.getID()));
            }
        }

        Utilisateur user = new Utilisateur(membre.getLogin(), membre.getPassword(), authorities);
        user.setMembreId(membre.getID());

        return user;

    }
}
