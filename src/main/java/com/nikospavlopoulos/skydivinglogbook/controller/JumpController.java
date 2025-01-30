package com.nikospavlopoulos.skydivinglogbook.controller;

import com.nikospavlopoulos.skydivinglogbook.core.exceptions.EntityInvalidArgumentException;
import com.nikospavlopoulos.skydivinglogbook.dto.JumpInsertDTO;
import com.nikospavlopoulos.skydivinglogbook.dto.JumpReadOnlyDTO;
import com.nikospavlopoulos.skydivinglogbook.mapper.Mapper;
import com.nikospavlopoulos.skydivinglogbook.model.Jump;
import com.nikospavlopoulos.skydivinglogbook.service.AircraftServiceImpl;
import com.nikospavlopoulos.skydivinglogbook.service.DropzoneServiceImpl;
import com.nikospavlopoulos.skydivinglogbook.service.JumpServiceImpl;
import com.nikospavlopoulos.skydivinglogbook.service.JumptypeServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for handling jump-related endpoints.
 * Provides GET and POST methods to render and process jump-related views.
 */

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class JumpController {

    private static final Logger LOGGER = LoggerFactory.getLogger(JumpController.class);

    // Service dependencies for data retrieval.
    private final JumpServiceImpl jumpServiceImpl;
    private final DropzoneServiceImpl dropzoneServiceImpl;
    private final AircraftServiceImpl aircraftServiceImpl;
    private final JumptypeServiceImpl jumptypeServiceImpl;

    // Mapper for converting entities to DTOs and vice versa.
    private final Mapper mapper;
    /**
     * Handles GET requests to "/jump".
     * Prepares the model with necessary data for rendering the jump form view.
     * @param model The Model object to populate attributes for the view.
     * @return The name of the HTML template to be rendered ("jump").
     */
    @GetMapping("/jump")
    public String getJump(Model model) {
        // Add a new JumpInsertDTO instance to the model for form binding.
        model.addAttribute("jumpInsertDTO", new JumpInsertDTO());

        // Add lists of all jump types, dropzones, and aircraft to the model, necessary for the dropdown menus
        model.addAttribute("allJumptypes", jumptypeServiceImpl.findAllJumptypes());
        model.addAttribute("allDropzones", dropzoneServiceImpl.findAllDropzones());
        model.addAttribute("allAircraft", aircraftServiceImpl.findAllAircraft());

        // Return the jump.html
        return "jump";
    }

    /**
     * Handles POST requests to "/jump".
     * Processes the form submission to save a new jump entry and handles errors if validation fails.
     * @param model          The Model object to populate attributes for the view.
     * @param jumpInsertDTO  The DTO containing user-submitted jump data.
     * @return The name of the HTML template to be rendered, either "jump" on error or "success" on success.
     */
    @PostMapping("/jump")
    public String saveJump(@ModelAttribute("jumpInsertDTO") @Valid JumpInsertDTO jumpInsertDTO, BindingResult bindingResult, Model model) {
        Jump savedJump;

        if (bindingResult.hasErrors()) {
            return "jump";
        }

        try {
            // Save the new jump using the service layer.
            savedJump = jumpServiceImpl.saveJump(jumpInsertDTO);
            LOGGER.info("Jump saved with id {} on date {}", savedJump.getId(), savedJump.getJumpDate());
        } catch (EntityInvalidArgumentException e) {
            LOGGER.error("Jump from {} feet on {} was not saved",
                    jumpInsertDTO.getAltitude(), jumpInsertDTO.getJumpDate());
            model.addAttribute("errorMessage", "An error occurred while saving the jump. Please try again.");
            return "jump";
        }

        // Convert the saved jump entity to a read-only DTO for display purposes.
        JumpReadOnlyDTO jumpReadOnlyDTO = mapper.mapToJumpReadOnlyDTO(savedJump);
        // Add the saved jump DTO to the model for the success view.
        model.addAttribute("jump", jumpReadOnlyDTO);
        // Return the success.html
        return "success";
    }
}
