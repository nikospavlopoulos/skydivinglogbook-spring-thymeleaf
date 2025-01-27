package com.nikospavlopoulos.skydivinglogbook.service;

import com.nikospavlopoulos.skydivinglogbook.core.exceptions.EntityInvalidArgumentException;
import com.nikospavlopoulos.skydivinglogbook.dto.JumpInsertDTO;
import com.nikospavlopoulos.skydivinglogbook.mapper.Mapper;
import com.nikospavlopoulos.skydivinglogbook.model.Jump;
import com.nikospavlopoulos.skydivinglogbook.repository.AircraftRepository;
import com.nikospavlopoulos.skydivinglogbook.repository.DropzoneRepository;
import com.nikospavlopoulos.skydivinglogbook.repository.JumpRepository;
import com.nikospavlopoulos.skydivinglogbook.repository.JumptypeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Implementation of the IJumpService interface to handle jump-related operations.
 * This service interacts with the database and converts input data into the required entity.
 */

@Service
@RequiredArgsConstructor
public class JumpServiceImpl implements IJumpService {

    // Repositories for database interactions
    private final JumpRepository jumpRepository;
    private final JumptypeRepository jumptypeRepository;
    private final DropzoneRepository dropzoneRepository;
    private final AircraftRepository aircraftRepository;

    // Mapper to transform DTOs into entities
    private final Mapper mapper;

    /**
     * Saves a new jump to the database.
     * Maps the JumpInsertDTO to a Jump entity and persists it.
     * @param dto the data transfer object containing jump information.
     * @return the saved Jump entity.
     * @throws EntityInvalidArgumentException if the input data is invalid.
     */
    @Override
    @Transactional (rollbackOn = Exception.class)
    public Jump saveJump(JumpInsertDTO dto) throws EntityInvalidArgumentException {

        Jump jump = mapper.mapToJumpEntity(dto); // Maps the input DTO to a Jump entity.

        return jumpRepository.save(jump); // Persists the jump entity to the database.
    }
}
