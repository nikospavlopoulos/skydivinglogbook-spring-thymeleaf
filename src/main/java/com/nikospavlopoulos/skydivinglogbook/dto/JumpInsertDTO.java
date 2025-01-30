package com.nikospavlopoulos.skydivinglogbook.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date jumpDate;

    /**
     * The altitude of the jump in feet.
     */
    @NotNull (message = "Can not be empty")
    @Min(value = 3000, message = "Altitude between 3000ft (otherwise it does not count)")
    @Max(value = 15000, message = "Unless you are Tom Cruise (I highly doubt it), you probably didn't go over 15000ft")
    private Integer altitude;

    /**
     * Duration of the freefall in seconds.
     */
    @NotNull (message = "Can not be empty")
    @Max(value = 80, message = "Maximum freefall seconds is 80 seconds unless you are Chuck Norris")
    private Integer freefallduration;

    /**
     * ID of the aircraft used for the jump. (optional)
     */
    private Long aircraftId;

    /**
     * Notes about the jump. (optional)
     */
    @Size(max = 500, message = "What are you writing? An essay? Keep it under 500 characters")
    private String jumpNotes;

}
