package com.nikospavlopoulos.skydivinglogbook.service;

import com.nikospavlopoulos.skydivinglogbook.model.static_data.Jumptype;
import com.nikospavlopoulos.skydivinglogbook.repository.JumptypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the IJumptypeService interface for managing jump types.
 */
@Service
@RequiredArgsConstructor
public class JumptypeServiceImpl implements IJumptypeService{

    // Repository to access jump type data.
    private final JumptypeRepository jumptypeRepository;

    /**
     * Retrieves all available jump types from the database.
     * @return a list of all Jumptype entities.
     */
    @Override
    public List<Jumptype> findAllJumptypes() {
        return jumptypeRepository.findAll(); // Queries the database for all jump types.
    }
}
