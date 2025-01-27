package com.nikospavlopoulos.skydivinglogbook.repository;

import com.nikospavlopoulos.skydivinglogbook.model.static_data.Dropzone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Repository interface for managing Dropzone entities.
 * Extends JpaRepository to provide CRUD operations.
 * Extends JpaSpecificationExecutor to allow complex queries using specifications.
 */
public interface DropzoneRepository extends JpaRepository<Dropzone, Long>, JpaSpecificationExecutor<Dropzone> {
}
