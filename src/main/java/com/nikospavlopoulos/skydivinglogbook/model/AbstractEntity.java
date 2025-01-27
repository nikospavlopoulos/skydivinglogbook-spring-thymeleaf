package com.nikospavlopoulos.skydivinglogbook.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * AbstractEntity serves as a base class for other entity classes in the application.
 * It provides common audit fields for tracking the creation and update timestamps.
 * The class uses JPA's auditing feature to automatically populate these fields.
 */

@MappedSuperclass // Indicates that this class is not an entity itself but can be extended by other entities.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert // Ensures that only non-null fields are included in the SQL INSERT statements.
@EntityListeners(AuditingEntityListener.class) // Enables auditing to automatically populate audit fields.
public class AbstractEntity implements Serializable {

    /**
     * The timestamp indicating when the entity was created.
     * It is automatically populated when the entity is persisted for the first time.
     */
    @CreatedDate // Marks this field to be populated with the creation timestamp by Spring Data JPA.
    @Column(name = "created_at", nullable = false, updatable = false) // Maps the field to the "created_at" column in the database.
    private LocalDateTime createdAt;

    /**
     * The timestamp indicating when the entity was last updated.
     * It is automatically updated whenever the entity is modified.
     */
    @LastModifiedDate // Marks this field to be populated with the last modified timestamp by Spring Data JPA.
    @Column(name = "updated_at") // Maps the field to the "updated_at" column in the database.
    private LocalDateTime updatedAt;

}
