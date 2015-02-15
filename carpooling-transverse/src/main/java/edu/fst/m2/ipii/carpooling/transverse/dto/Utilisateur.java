package edu.fst.m2.ipii.carpooling.transverse.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by Dimitri on 02/11/14.
 */
public class Utilisateur extends User {

    /**
     * Instantiates a new utilisateur.
     *
     * @param username    the username
     * @param password    the password
     * @param authorities the authorities
     */
    public Utilisateur(String username, String password, Collection<? extends GrantedAuthority> authorities) {
	    super(username, password, authorities);
    }

    /**
     * Instantiates a new utilisateur.
     *
     * @param username              the username
     * @param password              the password
     * @param enabled               the enabled
     * @param accountNonExpired     the account non expired
     * @param credentialsNonExpired the credentials non expired
     * @param accountNonLocked      the account non locked
     * @param authorities           the authorities
     */
    public Utilisateur(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired,
	    boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
	    super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    /**
     * Checks for authority.
     *
     * @param role the role
     * @return true, if successful
     */
    public boolean hasAuthority(String role) {
        for (GrantedAuthority autorithy : getAuthorities()) {
            if (autorithy.getAuthority().equals(role)) {
                return true;
            }
        }
        return false;
    }
}
