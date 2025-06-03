package com.example.EcomarketSPAweb.Controller;

import com.example.EcomarketSPAweb.Model.GestionEnvio;
import com.example.EcomarketSPAweb.Model.Shipping;
import com.example.EcomarketSPAweb.Services.GestionEnvioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gestionEnvios")
@Tag(name = "Administracion de envios")
public class GestionEnvioController {
    @Autowired
    private GestionEnvioService gestionEnvioService;

    @GetMapping
    @Operation(summary = "Se obtiene la lista de todos los envios activos")
    public String getGestionEnvio(){
        return gestionEnvioService.listarGestionEnvio();
    }

    @PostMapping
    @Operation(summary = "Se agrega un envio")
    public String postShipping(@RequestBody GestionEnvio gestionEnvio){
        return gestionEnvioService.agregarGestionEnvio(gestionEnvio);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Se consulta un envio segun su id")
    public String getGestionEnvioById(@PathVariable int id){
        return gestionEnvioService.obtenerGestionEnvioPorId(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Se elimina el envio una vez terminado o cancelado")
    public String deleteGestionEnvioById(@PathVariable int id){
        return gestionEnvioService.eliminarGestionEnvio(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Se modifica el estado del envio")
    public String putGestionEnvioById(@PathVariable int id, @RequestBody GestionEnvio gestionEnvio){
        return gestionEnvioService.actualizarGestionEnvio(id,gestionEnvio);
    }


}
