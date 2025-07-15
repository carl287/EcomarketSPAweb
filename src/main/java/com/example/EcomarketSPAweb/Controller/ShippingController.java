package com.example.EcomarketSPAweb.Controller;


import com.example.EcomarketSPAweb.Model.Shipping;
import com.example.EcomarketSPAweb.Model.Suppliers;
import com.example.EcomarketSPAweb.Services.ShippingService;
import com.example.EcomarketSPAweb.assemblers.ShippingModelAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/shippings")
@Tag(name = "Vista de envios")

public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @Autowired
    private ShippingModelAssembler assembler;

    @Operation(summary = "Lista todos los envíos", description = "Devuelve todos los envíos registrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Envíos listados correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno al listar envíos")
    })
    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<Shipping>>> getShipping() {
        try {
            List<Shipping> shippingList = shippingService.listarShipping();

            List<EntityModel<Shipping>> shippingModels = shippingList.stream()
                    .map(assembler::toModel)
                    .collect(Collectors.toList());

            CollectionModel<EntityModel<Shipping>> collectionModel = CollectionModel.of(shippingModels,
                    linkTo(methodOn(ShippingController.class).getShipping()).withSelfRel());

            return ResponseEntity.ok(collectionModel);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Agrega un envío (provisional)", description = "Agrega un nuevo envío. Este método será eliminado, ya que pertenece a gestión de envíos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Envío agregado correctamente"),
            @ApiResponse(responseCode = "400", description = "Error en los datos del envío"),
            @ApiResponse(responseCode = "500", description = "Error interno al agregar envío")
    })
    @PostMapping
    public ResponseEntity<String> postShipping(@RequestBody Shipping shipping) {
        try {
            String respuesta = shippingService.agregarShipping(shipping);
            return ResponseEntity.status(201).body(respuesta);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Datos inválidos para el envío.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al agregar envío.");
        }
    }

    @Operation(summary = "Obtiene un envío por ID", description = "Consulta la información de un envío según su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Envío encontrado correctamente"),
            @ApiResponse(responseCode = "404", description = "Envío no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno al consultar envío")
    })
    @GetMapping("/{id}")
    public ResponseEntity<String> getShippingById(@PathVariable int id) {
        try {
            String envio = shippingService.obtenerShippingPorId(id);
            if (envio == null || envio.isBlank()) {
                return ResponseEntity.status(404).body("Envío no encontrado.");
            }
            return ResponseEntity.ok(envio);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al consultar envío.");
        }
    }

    @Operation(summary = "Elimina un envío (provisional)", description = "Elimina un envío existente. Este método será eliminado, ya que pertenece a gestión de envíos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Envío eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Envío no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno al eliminar envío")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShippingById(@PathVariable int id) {
        try {
            String respuesta = shippingService.eliminarShipping(id);
            if (respuesta.contains("no encontrado")) {
                return ResponseEntity.status(404).body(respuesta);
            }
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al eliminar envío.");
        }
    }

    @Operation(summary = "Modifica un envío (provisional)", description = "Actualiza la información de un envío. Este método será eliminado, ya que pertenece a gestión de envíos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Envío actualizado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos para actualización"),
            @ApiResponse(responseCode = "404", description = "Envío no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno al actualizar envío")
    })
    @PutMapping("/{id}")
    public ResponseEntity<String> putShippingById(@PathVariable int id, @RequestBody Shipping shipping) {
        try {
            String respuesta = shippingService.actualizarShipping(id, shipping);
            if (respuesta.contains("no encontrado")) {
                return ResponseEntity.status(404).body(respuesta);
            }
            return ResponseEntity.ok(respuesta);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Datos inválidos para actualizar envío.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al actualizar envío.");
        }
    }
}
