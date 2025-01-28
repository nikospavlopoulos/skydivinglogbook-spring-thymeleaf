package com.nikospavlopoulos.skydivinglogbook.model.static_data;

import com.nikospavlopoulos.skydivinglogbook.model.Jump;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a Jumptype entity in the application.
 * This entity maps to the "jumptypes" table in the database and maintains
 * a relationship with the jumps that fall under this specific jump type.
 */
@Entity // Marks this class as a JPA entity for persistence.
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "jumptypes") // Maps this entity to the "jumptypes" table in the database.
public class Jumptype {

    /**
     * The unique identifier for each jump type.
     * It is auto-generated using the IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the jumptype (e.g., Belly, Angle, Freefly etc.).
     */
    private String jumptypeName;

    /**
     * A collection of jumps associated with this jumptype.
     */
    @Getter(AccessLevel.PRIVATE) // The annotation ensures this field is only accessible internally.
    @OneToMany(mappedBy = "jumptype")
    private Set<Jump> jumps = new HashSet<>();

    /**
     * Provides an unmodifiable(read-only) view of all associated jumps.
     * Ensures the integrity of the collection by preventing external modifications.
     *
     * @return An unmodifiable set of jumps associated with this aircraft.
     */
    public Set<Jump> getAllJumps() {
        if (jumps == null) jumps = new HashSet<>(); // Ensures the jumps collection is initialized. If the jumps collection is null, it initializes it to an empty HashSet
        return Collections.unmodifiableSet(jumps); // Returns an unmodifiable view of the collection. Ensures that callers cannot directly modify the collection. Data Integrity.
    }

    /**
     * Adds a jump to the jump type and sets the relationship.
     * This ensures both sides of the bidirectional relationship are consistent.
     *
     * @param jump The jump to add to the jump type.
     */
    public void addJump(Jump jump) {
        if (jumps == null) jumps = new HashSet<>(); // Ensures the jumps collection is initialized. If the jumps collection is null, it initializes it to an empty HashSet.
        jumps.add(jump); // Adds the jump to the collection.
        jump.setJumptype(this);
    }

}
