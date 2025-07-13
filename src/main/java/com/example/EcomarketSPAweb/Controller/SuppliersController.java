package com.example.EcomarketSPAweb.Controller;

import com.example.EcomarketSPAweb.Model.Suppliers;
import com.example.EcomarketSPAweb.Services.SuppliersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/suppliers")
@Tag(name = "Administracion y gestion de proovedores")
public class SuppliersController {


    @Autowired
    private SuppliersService supplierService;

    @Operation(summary = "Lista todos los proveedores", description = "Devuelve un listado completo de proveedores.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Proveedores listados correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno al listar proveedores")
    })
    @GetMapping
    public String getSuppliers() {
        return supplierService.listarSuppliers();
    }

    @Operation(summary = "Agrega un proveedor", description = "Registra un nuevo proveedor en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Proveedor agregado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos para agregar proveedor"),
            @ApiResponse(responseCode = "500", description = "Error interno al agregar proveedor")
    })
    @PostMapping
    public String postSuppliers(@RequestBody Suppliers suppliers) {
        return supplierService.agregarSupplier(suppliers);
    }

    @Operation(summary = "Obtiene un proveedor por ID", description = "Muestra los datos de un proveedor específico según su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Proveedor encontrado correctamente"),
            @ApiResponse(responseCode = "404", description = "Proveedor no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno al consultar proveedor")
    })
    @GetMapping("/{id}")
    public String getSuppliersById(@PathVariable int id) {
        return supplierService.obtenerSupplier(id);
    }

    @Operation(summary = "Elimina un proveedor por ID", description = "Elimina un proveedor existente en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Proveedor eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Proveedor no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno al eliminar proveedor")
    })
    @DeleteMapping("/{id}")
    public String deleteSuppliersById(@PathVariable int id) {
        return supplierService.eliminarSupplier(id);
    }

    @Operation(summary = "Actualiza un proveedor por ID", description = "Modifica los datos de un proveedor existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Proveedor actualizado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos para actualización"),
            @ApiResponse(responseCode = "404", description = "Proveedor no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno al actualizar proveedor")
    })
    @PutMapping("/{id}")
    public String putSuppliersById(@PathVariable int id, @RequestBody Suppliers suppliers) {
        return supplierService.actualizarSupplier(id, suppliers);
    }
}
