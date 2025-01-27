package com.nikospavlopoulos.skydivinglogbook.service;

import com.nikospavlopoulos.skydivinglogbook.model.static_data.Dropzone;

import java.util.List;

/**
 * Service interface for managing dropzones
 */
public interface IDropzoneService {

    /**
     * Retrieves a list of all available dropzones.
     * @return a list of Dropzone entities.
     */
    List<Dropzone> findAllDropzones();

}
