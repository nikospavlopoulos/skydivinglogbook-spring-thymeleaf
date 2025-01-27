package com.nikospavlopoulos.skydivinglogbook.service;

import com.nikospavlopoulos.skydivinglogbook.model.static_data.Jumptype;

import java.util.List;

/**
 * Service interface for managing jump types
 */
public interface IJumptypeService {

    /**
     * Retrieves a list of all available jump types.
     * @return a list of Jumptype entities.
     */
    List<Jumptype> findAllJumptypes();

}
