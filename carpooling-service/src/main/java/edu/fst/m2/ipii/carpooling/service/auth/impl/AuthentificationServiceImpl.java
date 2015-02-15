package edu.fst.m2.ipii.carpooling.service.auth.impl;


import edu.fst.m2.ipii.carpooling.service.auth.AuthentificationService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Dimitri on 02/11/14.
 */
@Service
public class AuthentificationServiceImpl implements AuthentificationService {

    /**
     * The user repository.
     */
    // @Autowired
    // private UserRepository userRepository;

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.core.userdetails.UserDetailsService#
     * loadUserByUsername(java.lang.String)
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

	    /* User user = userRepository.findOne(s);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("Utilisateur {} introuvable", s));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new Utilisateur(user.getLogin(), user.getPassword(), authorities);
        */

        return null;
    }
}
