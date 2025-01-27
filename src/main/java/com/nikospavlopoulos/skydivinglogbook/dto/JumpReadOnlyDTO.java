package com.nikospavlopoulos.skydivinglogbook.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Data Transfer Object (DTO) for representing a jump record in a read-only manner.
 * This class is used to transfer data about a jump without allowing modifications.
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JumpReadOnlyDTO {

    private Long id; // unique identifier of the jump record.
    private LocalDateTime createdAt; // timestamp when the jump record was created.
    private LocalDateTime updatedAt; // timestamp when the jump record was last updated.
    private String jumptype; // type of jump (e.g., belly, angle, formation etc).
    private String dropzone; // dropzone where the jump took place
    private Date jumpDate; // date of the jump.
    private Integer altitude; // altitude of the jump in feet.
    private Integer freefallduration; // duration of the freefall in seconds.
    private String aircraft; // aircraft used for the jump.
    private String jumpNotes; // notes or comments about the jump.

}
