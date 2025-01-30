package com.nikospavlopoulos.skydivinglogbook.authentication;

import com.nikospavlopoulos.skydivinglogbook.core.enums.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configures web application security, including authentication and authorization rules.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configures the security filter chain for the application.
     * @param http the HttpSecurity object used to define security rules.
     * @return a SecurityFilterChain that contains the configured security settings.
     * @throws Exception if an error occurs during configuration.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)  // Disables Cross-Site Request Forgery (CSRF) protection.
                .authorizeHttpRequests(authorize // Defines rules for authorizing HTTP requests.
                        -> authorize
                        .requestMatchers("/", "home.html").hasAnyAuthority(Role.SKYDIVER.name(), Role.ADMIN.name()) // Restricted to specific roles. Currently, All Logged
                        .requestMatchers("/jump/**").hasAnyAuthority(Role.SKYDIVER.name(), Role.ADMIN.name())  // Restricted to specific roles. Currently, All Logged
                        .requestMatchers("/success/**").hasAnyAuthority(Role.SKYDIVER.name(), Role.ADMIN.name()) // Restricted to specific roles. Currently All Logged In Roles.
                        // TODO Future feature  - ADMIN only Accesses All Users(SKYDIVERS) and is able to read all jump data  - Each SKYDIVER only has data logged by their own user account. Currently the APP does not have this functionality.

                        .requestMatchers("/login").permitAll() // Allows anyone to access the login page.
                        .requestMatchers("/register").permitAll() // Allows anyone to access the registration page.
                        .requestMatchers("/registersuccess").permitAll() // Allows anyone to access the registration success page.
                        .requestMatchers("/registerfail").permitAll() // Allows anyone to access the registration success page.
                        .requestMatchers("/css/**", "/img/**", "/js/**").permitAll() // Allows static resources.
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin   // Configures form-based login settings.
                        .loginPage("/login") // Configures form-based login settings.
                        .permitAll() // Allows anyone to access the login page.
                        .defaultSuccessUrl("/") // Redirects to the home page upon successful login.
                )
                .httpBasic(Customizer.withDefaults()) // Enables HTTP Basic authentication.
                .logout(logout -> logout // Configures logout behavior.
                        .logoutSuccessUrl("/login") // Redirects to the login page after logout.
                        .invalidateHttpSession(true) // Invalidates the HTTP session.
                        .deleteCookies("JSESSIONID") // Deletes the session cookie.
                );
        return http.build(); // Builds and returns the configured security filter chain for a new login-register etc
    }
}