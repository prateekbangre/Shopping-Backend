package com.prateek.bangre.run.service;

import com.prateek.bangre.jpa_repository.UsersRepository;
import com.prateek.bangre.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

/**
 * @author prateek.bangre on 30/04/20.
 * @Project Shoping-Backend
 */

@Component
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = usersRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

}
