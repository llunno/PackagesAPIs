package br.edu.infnet.packagedetiny.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AppController {

    @GetMapping(value = "/")
    public String redirectMain() {
        return "redirect:/swagger-ui/index.html";
    }
}
