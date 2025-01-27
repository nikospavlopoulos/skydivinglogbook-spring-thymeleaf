package com.nikospavlopoulos.skydivinglogbook.mapper;

import com.nikospavlopoulos.skydivinglogbook.dto.JumpInsertDTO;
import com.nikospavlopoulos.skydivinglogbook.dto.JumpReadOnlyDTO;
import com.nikospavlopoulos.skydivinglogbook.model.Jump;
import org.springframework.stereotype.Component;

/**
 * The Mapper class is responsible for converting between entity objects (e.g., Jump) and
 * Data Transfer Objects (DTOs) like JumpInsertDTO and JumpReadOnlyDTO.
 * It ensures a clear separation between the application layers by handling the mapping logic.
 */

@Component
public class Mapper {

    /**
     * Converts a JumpInsertDTO into a Jump entity object.
     * @param jumpInsertDTO the DTO containing data for a new Jump.
     * @return a new Jump entity populated with the provided DTO data.
     */

    public Jump mapToJumpEntity(JumpInsertDTO jumpInsertDTO) {
        Jump jump = new Jump();
//        jump.getJumptype(jumpInsertDTO.getJumptypeId());
//        jump.setDropzone(jumpInsertDTO.getDropzoneId());
        jump.setJumpDate(jumpInsertDTO.getJumpDate());
        jump.setAltitude(jumpInsertDTO.getAltitude());
        jump.setFreefallduration(jumpInsertDTO.getFreefallduration());
//        jump.setAircraft(jumpInsertDTO.getAircraftId());
        jump.setJumpNotes(jumpInsertDTO.getJumpNotes());
        return jump;
    }

    /**
     * Converts a Jump entity into a JumpReadOnlyDTO.
     *
     * @param jump the Jump entity to be converted.
     * @return a JumpReadOnlyDTO populated with data from the Jump entity.
     */

    public JumpReadOnlyDTO mapToJumpReadOnlyDTO(Jump jump) {
        return new JumpReadOnlyDTO(
                jump.getId(),
                jump.getCreatedAt(),
                jump.getUpdatedAt(),
                jump.getJumptype().getJumptypeName(),
                jump.getDropzone().getDropzoneName(),
                jump.getJumpDate(),
                jump.getAltitude(),
                jump.getFreefallduration(),
                jump.getAircraft().getAircraftName(),
                jump.getJumpNotes()
        );


    }


}
