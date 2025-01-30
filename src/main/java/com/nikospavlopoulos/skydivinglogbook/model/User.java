package com.nikospavlopoulos.skydivinglogbook.model;

import com.nikospavlopoulos.skydivinglogbook.core.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Represents a user entity in the database.
 * This class implements the {@link UserDetails} interface, which is required by Spring Security
 * for user authentication and authorization.
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username; //Username of the user, acts as a unique identifier
    private String password; //Encrypted password of the user.

    @Enumerated(EnumType.STRING) // Persists the enum value as a String in the database.
    private Role role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { //Returns the authorities granted to the user for role-based access control
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
