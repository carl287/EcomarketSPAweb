package com.example.EcomarketSPAweb.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BienvenidaController {

    @GetMapping("/hola")
    public String bienvenida() {
        return "Somos EcoMarket, Bienvenido :)";
    }
}
