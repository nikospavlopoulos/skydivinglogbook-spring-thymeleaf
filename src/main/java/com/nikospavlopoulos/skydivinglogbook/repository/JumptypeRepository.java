package com.nikospavlopoulos.skydivinglogbook.repository;

import com.nikospavlopoulos.skydivinglogbook.model.static_data.Jumptype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Repository interface for managing Jumptype entities.
 * Extends JpaRepository to provide CRUD operations.
 * Extends JpaSpecificationExecutor to allow complex queries using specifications.
 */
public interface JumptypeRepository extends JpaRepository<Jumptype, Long>, JpaSpecificationExecutor<Jumptype> {
}
