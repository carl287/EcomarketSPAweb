package com.example.EcomarketSPAweb.Controller;

import com.example.EcomarketSPAweb.Model.GestionEnvio;
import com.example.EcomarketSPAweb.Model.Shipping;
import com.example.EcomarketSPAweb.Services.GestionEnvioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gestionEnvios")
@Tag(name = "Administracion de envios")
public class GestionEnvioController {


    @Autowired
    private GestionEnvioService gestionEnvioService;

    @Operation(summary = "Obtiene todos los envíos activos", description = "Devuelve una lista con todos los envíos activos registrados en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de envíos obtenida correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno al obtener los envíos")
    })
    @GetMapping
    public ResponseEntity<String> getGestionEnvio() {
        try {
            return ResponseEntity.ok(gestionEnvioService.listarGestionEnvio());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al obtener la lista de envíos.");
        }
    }

    @Operation(summary = "Agrega un nuevo envío", description = "Registra un nuevo envío en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Envío agregado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos para crear el envío"),
            @ApiResponse(responseCode = "500", description = "Error interno al agregar el envío")
    })
    @PostMapping
    public ResponseEntity<String> postShipping(@RequestBody GestionEnvio gestionEnvio) {
        try {
            return ResponseEntity.ok(gestionEnvioService.agregarGestionEnvio(gestionEnvio));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al agregar el envío.");
        }
    }

    @Operation(summary = "Consulta un envío por ID", description = "Obtiene los detalles de un envío específico a partir de su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Envío encontrado correctamente"),
            @ApiResponse(responseCode = "404", description = "Envío no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno al consultar el envío")
    })
    @GetMapping("/{id}")
    public ResponseEntity<String> getGestionEnvioById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(gestionEnvioService.obtenerGestionEnvioPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Elimina un envío", description = "Elimina un envío del sistema, ya sea porque fue completado o cancelado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Envío eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Envío no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno al eliminar el envío")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGestionEnvioById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(gestionEnvioService.eliminarGestionEnvio(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Modifica un envío", description = "Actualiza el estado u otra información del envío identificado por su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Envío actualizado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos para actualización"),
            @ApiResponse(responseCode = "404", description = "Envío no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno al actualizar el envío")
    })
    @PutMapping("/{id}")
    public ResponseEntity<String> putGestionEnvioById(@PathVariable int id, @RequestBody GestionEnvio gestionEnvio) {
        try {
            return ResponseEntity.ok(gestionEnvioService.actualizarGestionEnvio(id, gestionEnvio));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
