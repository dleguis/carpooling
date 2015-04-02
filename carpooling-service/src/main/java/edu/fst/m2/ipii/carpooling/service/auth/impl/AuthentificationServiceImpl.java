package edu.fst.m2.ipii.carpooling.service.auth.impl;


import edu.fst.m2.ipii.carpooling.domaine.bo.Membre;
import edu.fst.m2.ipii.carpooling.domaine.repository.MembreRepository;
import edu.fst.m2.ipii.carpooling.service.auth.AuthentificationService;
import edu.fst.m2.ipii.carpooling.transverse.dto.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dimitri on 02/11/14.
 */
@Service
public class AuthentificationServiceImpl implements AuthentificationService {

    /**
     * The user repository.
     */
    @Autowired
    private MembreRepository membreRepository;

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.core.userdetails.UserDetailsService#
     * loadUserByUsername(java.lang.String)
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

	    Membre membre = membreRepository.findByLogin(s).get(0);

        if (membre == null) {
            throw new UsernameNotFoundException(String.format("Utilisateur {} introuvable", s));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new Utilisateur(membre.getLogin(), membre.getPassword(), authorities);

    }
}
