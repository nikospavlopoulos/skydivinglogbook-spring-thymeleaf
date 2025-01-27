package com.nikospavlopoulos.skydivinglogbook.service;

import com.nikospavlopoulos.skydivinglogbook.core.exceptions.EntityInvalidArgumentException;
import com.nikospavlopoulos.skydivinglogbook.dto.JumpInsertDTO;
import com.nikospavlopoulos.skydivinglogbook.model.Jump;

/**
 * Service interface for managing jumps
 */
public interface IJumpService {

    /**
     * Saves a new jump in the database.
     *
     * @param dto the data transfer object containing jump information.
     * @return the saved Jump entity.
     * @throws EntityInvalidArgumentException if any of the provided data is invalid.
     */
    Jump saveJump(JumpInsertDTO dto) throws EntityInvalidArgumentException;

}
