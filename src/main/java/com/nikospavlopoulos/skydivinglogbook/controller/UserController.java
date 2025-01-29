package com.nikospavlopoulos.skydivinglogbook.controller;

import com.nikospavlopoulos.skydivinglogbook.dto.UserInsertDTO;
import com.nikospavlopoulos.skydivinglogbook.mapper.Mapper;
import com.nikospavlopoulos.skydivinglogbook.model.User;
import com.nikospavlopoulos.skydivinglogbook.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {  /// Question: What does this do? Explain each part in detail outside the code.

    private final UserService userService;
    private final Mapper mapper;

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
    ) {
        if (bindingResult.hasErrors()) {
            return "user-form";
        }

        User user = mapper.mapToUserEntity(userInsertDTO);
        userService.saveUser(user);
        return "redirect:/users/register?success"; // TODO Maybe I need to create a new register page ?
    }
}
