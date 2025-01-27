package com.nikospavlopoulos.skydivinglogbook.repository;

import com.nikospavlopoulos.skydivinglogbook.model.static_data.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Repository interface for managing Aircraft entities.
 * Extends JpaRepository to provide CRUD operations.
 * Extends JpaSpecificationExecutor to allow complex queries using specifications.
 */
public interface AircraftRepository extends JpaRepository<Aircraft, Long>, JpaSpecificationExecutor<Aircraft> {
}
