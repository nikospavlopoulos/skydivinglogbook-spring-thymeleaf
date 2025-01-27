package com.nikospavlopoulos.skydivinglogbook.model;

import com.nikospavlopoulos.skydivinglogbook.model.static_data.Aircraft;
import com.nikospavlopoulos.skydivinglogbook.model.static_data.Dropzone;
import com.nikospavlopoulos.skydivinglogbook.model.static_data.Jumptype;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * Represents a skydive jump record in the application.
 * This entity maps to the "jump" table in the database and
 * contains details about individual jumps.
 */

@Entity // Marks this class as a JPA entity to be managed by Hibernate.
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "jump") // Specifies the database table name for this entity.
public class Jump extends AbstractEntity {

    /**
     * The unique identifier for each aircraft.
     * It is auto-generated using the IDENTITY strategy.
     */
    @Id // Marks this field as the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     * The type of jump (e.g., Belly, Angle, Freefly, etc).
     * Establishes a many-to-one relationship with the Jumptype entity.
     */
    @ManyToOne
    @JoinColumn (name = "jumptype_id")
    private Jumptype jumptype;

    /**
     * The dropzone where the jump took place (e.g., Skydive Athens).
     * Establishes a many-to-one relationship with the Dropzone entity.
     */
    @ManyToOne
    @JoinColumn (name = "dropzone_id")
    private Dropzone dropzone;

    /**
     * The date when the jump took place.
     */
    private Date jumpDate;

    /**
     * The altitude (in feet) from which the jump was made.
     * Example: 13,000 feet.
     */
    private Integer altitude;

    /**
     * The duration (in seconds) of freefall during the jump.
     * Example: 55 seconds.
     */
    private Integer freefallduration;

    @ManyToOne
    @JoinColumn(name = "aircraft_id")
    private Aircraft aircraft;

    /**
     * Additional notes or comments about the jump.
     */
    private String jumpNotes;

}
