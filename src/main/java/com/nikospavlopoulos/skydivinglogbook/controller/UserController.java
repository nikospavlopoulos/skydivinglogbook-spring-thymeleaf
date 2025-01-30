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

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final UserServiceImpl userServiceImpl;
    private final Mapper mapper;

    @GetMapping("/registersuccess")
    public String registerSuccess() {
        return "registersuccess";
    }

    @GetMapping("/registerfail")
    public String registerFail() {
        return "registerfail";
    }

    @GetMapping("/login")
    public String login(Principal principal, Model model) {
        model.addAttribute("userInsertDTO", new UserInsertDTO());
        return principal == null ? "login" : "redirect:/";
    }

    @PostMapping("/login")
    public String loginForm(@Valid @ModelAttribute("userInsertDTO")
                            UserInsertDTO userInsertDTO,
                            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        return "home";
    }
    @GetMapping("/register")
    public String getUserForm(Model model) {
        model.addAttribute("userInsertDTO", new UserInsertDTO());
        return "register";
    }


    @PostMapping("/register")
    public String insertUser(@Valid @ModelAttribute("userInsertDTO")
                             UserInsertDTO userInsertDTO,
                             BindingResult bindingResult,
                             Model model
    ) throws EntityAlreadyExistsException {

        if (bindingResult.hasErrors()) {
            return "registerfail";
        }

        User insertedUser;

        try{
            insertedUser = userServiceImpl.saveUser(userInsertDTO);
            LOGGER.info("User with Username {} inserted", insertedUser.getUsername());

        } catch (EntityAlreadyExistsException e) {
            LOGGER.error("Error while inserting user {} User already exists", userInsertDTO.getUsername());
            return "registerfail";
        }

        return "registersuccess";
    }



}