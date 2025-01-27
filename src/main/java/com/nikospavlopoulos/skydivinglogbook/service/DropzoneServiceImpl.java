package com.nikospavlopoulos.skydivinglogbook.service;

import com.nikospavlopoulos.skydivinglogbook.model.static_data.Dropzone;
import com.nikospavlopoulos.skydivinglogbook.repository.DropzoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the IDropzoneService interface for managing dropzones.
 */
@Service
@RequiredArgsConstructor
public class DropzoneServiceImpl implements IDropzoneService{

    // Repository to access dropzone data.
    private final DropzoneRepository dropzoneRepository;

    /**
     * Retrieves all available dropzones from the database.
     * @return a list of all Dropzone entities.
     */
    @Override
    public List<Dropzone> findAllDropzones() {
        return dropzoneRepository.findAll(); // Queries the database for all dropzones.
    }
}
