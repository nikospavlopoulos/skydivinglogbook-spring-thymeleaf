package com.nikospavlopoulos.skydivinglogbook.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Data Transfer Object (DTO) for inserting a new jump record.
 * This class encapsulates the input data for a new jump
 * and provides validation constraints to ensure data integrity.
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JumpInsertDTO {


    /**
     * ID of the jump type associated with this jump. (required)
     */
    @NotNull (message = "Can not be empty")
    private Long jumptypeId;

    /**
     * ID of the dropzone associated with this jump. (required)
     */
    @NotNull (message = "Can not be empty")
    private Long dropzoneId;

    /**
     * The date when the jump was made. (required)
     */
    @NotNull (message = "Can not be empty")
    private Date jumpDate;

    /**
     * The altitude of the jump in feet.
     */
    @NotNull (message = "Can not be empty")
    @Size(min = 3000, max = 15000, message = "Altitude between 3000ft (otherwise it does not count) and 15000ft")
    private Integer altitude;

    /**
     * Duration of the freefall in seconds.
     */
    @NotNull (message = "Can not be empty")
    @Size(max = 80, message = "Maximum freefall seconds is 80 seconds unless you are Tom Cruise")
    private Integer freefallduration;

    /**
     * ID of the aircraft used for the jump. (optional)
     */
    private Long aircraftId;

    /**
     * Notes about the jump. (optional)
     */
    @Size(max = 300, message = "What are you writing? An essay? Keep it under 300 characters")
    private String jumpNotes;

}
