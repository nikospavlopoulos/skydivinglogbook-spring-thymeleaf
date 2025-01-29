package com.nikospavlopoulos.skydivinglogbook.authentication;

import com.nikospavlopoulos.skydivinglogbook.core.enums.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration /// Question: What does this @Configuration do? Explain in detail
@EnableWebSecurity  /// Question: What does this @EnableWebSecurity do? Explain in detail
public class SecurityConfig { /// Question: What does this class do? Explain in detail

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { /// Question: I don't understand anything about what does this class do? Comment each line extensively and outsite the code explain each one in detail
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize
                        -> authorize
                        .requestMatchers("/", "home.html").permitAll()
                        .requestMatchers("/jump/**").hasAnyAuthority(Role.SKYDIVER.name(), Role.ADMIN.name())
                        .requestMatchers("/register").permitAll()
                        .requestMatchers("/css/**").permitAll()
                        .requestMatchers("/img/**").permitAll()
                        //.requestMatchers("/js/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")   /// Question: This is the default for POST Requests. How to change it to my own login page that I have in the templates and make sure I get the information using thymeleaf?
                        .permitAll()
                        .defaultSuccessUrl("/")
                )
                .httpBasic(Customizer.withDefaults())
                .logout(logout -> logout
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                );
        return http.build();
    }
}