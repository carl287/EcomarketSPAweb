package com.example.EcomarketSPAweb.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Pagina inicial de bienvenida")
public class BienvenidaController {

    @GetMapping("")
    @Operation(summary = "se le da un saludo de bienvenida al cliente o usuario que entre en la pagina")
    public String bienvenida() {
        return "Somos EcoMarket, Bienvenido :)";
    }
}
