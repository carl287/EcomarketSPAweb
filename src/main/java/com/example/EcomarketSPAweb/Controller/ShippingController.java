package com.example.EcomarketSPAweb.Controller;


import com.example.EcomarketSPAweb.Model.Product;
import com.example.EcomarketSPAweb.Model.Shipping;
import com.example.EcomarketSPAweb.Services.ProductService;
import com.example.EcomarketSPAweb.Services.ShippingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shippings")
@Tag(name = "Vista de envios")

public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @Operation(summary = "Lista todos los envíos", description = "Devuelve todos los envíos registrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Envíos listados correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno al listar envíos")
    })
    @GetMapping
    public String getShipping() {
        return shippingService.listarShipping();
    }

    @Operation(summary = "Agrega un envío (provisional)", description = "Agrega un nuevo envío. Este método será eliminado, ya que pertenece a gestión de envíos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Envío agregado correctamente"),
            @ApiResponse(responseCode = "400", description = "Error en los datos del envío"),
            @ApiResponse(responseCode = "500", description = "Error interno al agregar envío")
    })
    @PostMapping
    public String postShipping(@RequestBody Shipping shipping) {
        return shippingService.agregarShipping(shipping);
    }

    @Operation(summary = "Obtiene un envío por ID", description = "Consulta la información de un envío según su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Envío encontrado correctamente"),
            @ApiResponse(responseCode = "404", description = "Envío no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno al consultar envío")
    })
    @GetMapping("/{id}")
    public String getShippingById(@PathVariable int id) {
        return shippingService.obtenerShippingPorId(id);
    }

    @Operation(summary = "Elimina un envío (provisional)", description = "Elimina un envío existente. Este método será eliminado, ya que pertenece a gestión de envíos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Envío eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Envío no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno al eliminar envío")
    })
    @DeleteMapping("/{id}")
    public String deleteShippingById(@PathVariable int id) {
        return shippingService.eliminarShipping(id);
    }

    @Operation(summary = "Modifica un envío (provisional)", description = "Actualiza la información de un envío. Este método será eliminado, ya que pertenece a gestión de envíos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Envío actualizado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos para actualización"),
            @ApiResponse(responseCode = "404", description = "Envío no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno al actualizar envío")
    })
    @PutMapping("/{id}")
    public String putShippingById(@PathVariable int id, @RequestBody Shipping shipping) {
        return shippingService.actualizarShipping(id, shipping);
    }
}
