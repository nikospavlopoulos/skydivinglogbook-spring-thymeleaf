package com.nikospavlopoulos.skydivinglogbook.authentication;

import com.nikospavlopoulos.skydivinglogbook.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Custom implementation of the UserDetailsService interface, used to load user-specific data
 * during authentication.
 */
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService { /// Question: What does this class do? Explain in detail

    private final UserRepository userRepository;

    /**
     * Loads the user's details by their username.
     * @param username the username of the user whose details are to be loaded.
     * @return the UserDetails object containing user credentials and authorities.
     * @throws UsernameNotFoundException if the user cannot be found in the database.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(()   // Queries the database for the user by username(from UserRepository). Throws an exception if not found.
                -> new UsernameNotFoundException("User not found " + username));
    }

}
