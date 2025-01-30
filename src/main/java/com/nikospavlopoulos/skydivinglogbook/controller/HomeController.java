package com.nikospavlopoulos.skydivinglogbook.controller;

import com.nikospavlopoulos.skydivinglogbook.dto.JumpReadOnlyDTO;
import com.nikospavlopoulos.skydivinglogbook.service.JumpServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * HomeController is responsible for handling requests to the home page of the application.
 * It interacts with the JumpService to retrieve and display paginated jump data.
 */
@Controller
public class HomeController {

    private final JumpServiceImpl jumpServiceImpl;

    public HomeController(JumpServiceImpl jumpServiceImpl) {
        this.jumpServiceImpl = jumpServiceImpl;
    }

    /**
     * Handles GET requests to the root URL ("/").
     * Retrieves a paginated list of jumps and adds it to the model for rendering in the view.
     * @param page the page number to retrieve (default is 0)
     * @param size the number of items per page (default is 5)
     * @param model the Model object used to pass data to the view
     * @return the name of the view to be rendered (home)
     */
    @GetMapping("/")
    public String home(@RequestParam(defaultValue = "0") int page, // Page number, defaulting to 0 if not provided
                       @RequestParam(defaultValue = "5") int size, // Page size, defaulting to 5 if not provided
                       Model model) { // Model object for passing attributes to the view

        Page<JumpReadOnlyDTO> jumpsPage = jumpServiceImpl.getPaginatedJumps(page, size); // Retrieve a paginated list of jumps from the service

        model.addAttribute("jumpsPage", jumpsPage); // Add the retrieved jumps page to the model for the view
        model.addAttribute("currentPage", page); // Add the current page number to the model
        model.addAttribute("totalPages", jumpsPage.getTotalPages()); // Add the total number of pages to the model

        return "home";
    }


}
