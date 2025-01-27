package com.nikospavlopoulos.skydivinglogbook.service;

import com.nikospavlopoulos.skydivinglogbook.model.static_data.Aircraft;

import java.util.List;

/**
 * Service interface for managing aircraft
 */
public interface IAircraftService {

    /**
     * Retrieves a list of all available aircraft.
     * @return a list of Aircraft entities.
     */
    List<Aircraft> findAllAircraft();

}
