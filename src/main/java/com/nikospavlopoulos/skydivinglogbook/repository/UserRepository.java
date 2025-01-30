package com.nikospavlopoulos.skydivinglogbook.repository;

import com.nikospavlopoulos.skydivinglogbook.core.enums.Role;
import com.nikospavlopoulos.skydivinglogbook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * Repository interface for performing database operations on the User entity.
 * Extends JpaRepository to provide CRUD operations and JpaSpecificationExecutor for custom queries.
 */

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> { /// Question: What does this class do? Explain in detail

    Optional<User> findByUsername(String username);
//    Optional<User> findByEmail(String email);
    Optional<User> findByRole(Role role);

}
