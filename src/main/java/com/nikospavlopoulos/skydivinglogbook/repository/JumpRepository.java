package com.nikospavlopoulos.skydivinglogbook.repository;

import com.nikospavlopoulos.skydivinglogbook.model.Jump;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Repository interface for managing Jump entities.
 * Extends JpaRepository to provide CRUD operations.
 * Extends JpaSpecificationExecutor to allow complex queries using specifications.
 */

public interface JumpRepository extends JpaRepository<Jump, Long>, JpaSpecificationExecutor<Jump> {

//    List<Jump> findByDropzone_DropzoneName(String dropzoneName);
//    List<Jump> findByJumptype_JumpTypeName(String jumptypeName);

}
