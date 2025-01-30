package com.nikospavlopoulos.skydivinglogbook.controller;

import com.nikospavlopoulos.skydivinglogbook.core.exceptions.EntityAlreadyExistsException;
import com.nikospavlopoulos.skydivinglogbook.dto.UserInsertDTO;
import com.nikospavlopoulos.skydivinglogbook.mapper.Mapper;
import com.nikospavlopoulos.skydivinglogbook.model.User;
import com.nikospavlopoulos.skydivinglogbook.service.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * UserController handles user-related operations such as registration and login.
 * It provides endpoints for user registration, login, and success/failure responses.
 */

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final UserServiceImpl userServiceImpl;
    private final Mapper mapper;

    @GetMapping("/registersuccess") //Displays the registration success page.
    public String registerSuccess() {
        return "registersuccess";
    }

    @GetMapping("/registerfail") //Displays the registration failure page.
    public String registerFail() {
        return "registerfail";
    }

    /**
     * Displays the login page.
     * @param principal the authenticated user (if any)
     * @param model the Model object used to pass data to the view
     * @return the name of the view to be rendered (login or redirect to home)
     */
    @GetMapping("/login")
    public String login(Principal principal, Model model) {
        model.addAttribute("userInsertDTO", new UserInsertDTO());
        return principal == null ? "login" : "redirect:/";
    }

    /**
     * Handles the login form submission.
     * @param userInsertDTO the user data from the login form
     * @param bindingResult the result of the validation
     * @param model the Model object used to pass data to the view
     * @return the name of the view to be rendered (login or home)
     */
    @PostMapping("/login")
    public String loginForm(@Valid @ModelAttribute("userInsertDTO")
                            UserInsertDTO userInsertDTO,
                            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        return "home";
    }

    /**
     * Displays the user registration form.
     * @param model the Model object used to pass data to the view
     * @return the name of the view to be rendered (register)
     */
    @GetMapping("/register")
    public String getUserForm(Model model) {
        model.addAttribute("userInsertDTO", new UserInsertDTO());
        return "register";
    }


    /**
     * Handles the user registration form submission.
     * @param userInsertDTO the user data from the registration form
     * @param bindingResult the result of the validation
     * @param model the Model object used to pass data to the view
     * @return the name of the view to be rendered (registerfail or registersuccess)
     * @throws EntityAlreadyExistsException if the user already exists in the system
     */
    @PostMapping("/register")
    public String insertUser(@Valid @ModelAttribute("userInsertDTO") // Validates the userInsertDTO
                             UserInsertDTO userInsertDTO,
                             BindingResult bindingResult,
                             Model model
    ) throws EntityAlreadyExistsException {

        if (bindingResult.hasErrors()) { // Checks if there are validation errors
            return "registerfail";
        }

        User insertedUser;

        try{
            insertedUser = userServiceImpl.saveUser(userInsertDTO); // Attempts to save the user using the user service
            LOGGER.info("User with Username {} inserted", insertedUser.getUsername());

        } catch (EntityAlreadyExistsException e) { // Catches the exception if the user already exists
            LOGGER.error("Error while inserting user {} User already exists", userInsertDTO.getUsername());
            return "registerfail";
        }

        return "registersuccess";
    }



}