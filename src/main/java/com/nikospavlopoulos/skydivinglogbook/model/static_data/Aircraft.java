package com.nikospavlopoulos.skydivinglogbook.model.static_data;

import com.nikospavlopoulos.skydivinglogbook.model.Jump;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents an Aircraft entity in the application.
 * This entity maps to the "aircraft" table in the database and maintains
 * relationships with jumps associated with the aircraft.
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "aircraft")
public class Aircraft {

    /**
     * The unique identifier for each aircraft.
     * It is auto-generated using the IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the aircraft.
     */
    private String aircraftName;

    /**
     * A collection of jumps associated with this aircraft.
     */
    @Getter(AccessLevel.PRIVATE) // The annotation ensures this field is only accessible internally.
    @OneToMany(mappedBy = "aircraft")
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
     * Convenience method: Includes common, repetitive tasks that involve multiple operations
     * Adds a jump to the aircraft and sets the relationship.
     * This ensures both sides of the bidirectional relationship are consistent.
     *
     * @param jump The jump to add to the aircraft.
     */
    public void addJump(Jump jump) {
        if (jumps == null) jumps = new HashSet<>(); // Ensures the jumps collection is initialized. If the jumps collection is null, it initializes it to an empty HashSet.
        jumps.add(jump); // Adds the jump to the collection.
        jump.setAircraft(this); // Sets the "aircraft" field in the Jump entity to establish the relationship.
    }

}
