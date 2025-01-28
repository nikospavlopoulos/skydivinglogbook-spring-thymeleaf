package com.nikospavlopoulos.skydivinglogbook.service;

import com.nikospavlopoulos.skydivinglogbook.model.static_data.Aircraft;
import com.nikospavlopoulos.skydivinglogbook.repository.AircraftRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the IAircraftService interface for managing aircraft.
 */
@Service
@RequiredArgsConstructor
public class AircraftServiceImpl implements IAircraftService{

    // Repository to access aircraft data.
    private final AircraftRepository aircraftRepository;

    /**
     * Retrieves all available aircraft from the database.
     * @return a list of all Aircraft entities.
     */
    @Override
    @Transactional
    public List<Aircraft> findAllAircraft() {
        return aircraftRepository.findAll(); // Queries the database for all aircraft.
    }
}
