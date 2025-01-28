package com.nikospavlopoulos.skydivinglogbook.controller;

import com.nikospavlopoulos.skydivinglogbook.dto.JumpReadOnlyDTO;
import com.nikospavlopoulos.skydivinglogbook.service.JumpServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final JumpServiceImpl jumpServiceImpl;

    public HomeController(JumpServiceImpl jumpServiceImpl) {
        this.jumpServiceImpl = jumpServiceImpl;
    }

    @GetMapping("/")
    public String home(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "5") int size,
                       Model model) {

        Page<JumpReadOnlyDTO> jumpsPage = jumpServiceImpl.getPaginatedJumps(page, size);

        model.addAttribute("jumpsPage", jumpsPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", jumpsPage.getTotalPages());

        return "home";
    }


}
