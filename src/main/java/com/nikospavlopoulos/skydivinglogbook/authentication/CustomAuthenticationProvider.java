package com.nikospavlopoulos.skydivinglogbook.authentication;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configures custom authentication logic for the application, including password encoding
 * and the mechanism for fetching user details.
 */
@Configuration
@RequiredArgsConstructor
public class CustomAuthenticationProvider {

    private final UserDetailsService userDetailsService;

    /**
     * Configures the authentication provider with a custom user details service
     * and password encoder.
     * @return an AuthenticationProvider that uses the configured services.
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider(); // The DaoAuthenticationProvider is a Spring Security component used to validate user credentials.
        daoAuthenticationProvider.setUserDetailsService(userDetailsService); // Sets the service to fetch user details.
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder()); // Configures the password encoder (bcrypt).
        return daoAuthenticationProvider;
    }

    /**
     * Creates an AuthenticationManager bean to manage authentication logic.
     * @param config the Spring Security authentication configuration.
     * @return an AuthenticationManager instance.
     * @throws Exception if an error occurs while fetching the authentication manager.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    /**
     * Creates a PasswordEncoder bean that uses the bcrypt hashing algorithm.
     * @return a BCryptPasswordEncoder instance.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
