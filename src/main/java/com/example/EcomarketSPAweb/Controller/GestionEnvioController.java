package com.example.EcomarketSPAweb.Controller;

import com.example.EcomarketSPAweb.Model.GestionEnvio;
import com.example.EcomarketSPAweb.Model.Shipping;
import com.example.EcomarketSPAweb.Services.GestionEnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gestionEnvios")
public class GestionEnvioController {
    @Autowired
    private GestionEnvioService gestionEnvioService;

    @GetMapping
    public String getGestionEnvio(){
        return gestionEnvioService.listarGestionEnvio();
    }

    @PostMapping
    public String postShipping(@RequestBody GestionEnvio gestionEnvio){
        return gestionEnvioService.agregarGestionEnvio(gestionEnvio);
    }

    @GetMapping("/{id}")
    public String getGestionEnvioById(@PathVariable int id){
        return gestionEnvioService.obtenerGestionEnvioPorId(id);
    }

    @DeleteMapping("/{id}")
    public String deleteGestionEnvioById(@PathVariable int id){
        return gestionEnvioService.eliminarGestionEnvio(id);
    }

    @PutMapping("/{id}")
    public String putGestionEnvioById(@PathVariable int id, @RequestBody GestionEnvio gestionEnvio){
        return gestionEnvioService.actualizarGestionEnvio(id,gestionEnvio);
    }


}
