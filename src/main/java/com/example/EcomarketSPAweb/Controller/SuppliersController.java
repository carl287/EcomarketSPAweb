package com.example.EcomarketSPAweb.Controller;

import com.example.EcomarketSPAweb.Model.Suppliers;
import com.example.EcomarketSPAweb.Services.SuppliersService;
import com.example.EcomarketSPAweb.assemblers.SuppliersModelAssembler;
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
@RequestMapping("/suppliers")
@Tag(name = "Administracion y gestion de proovedores")
public class SuppliersController {


    @Autowired
    private SuppliersService supplierService;

    @Autowired
    private SuppliersModelAssembler assembler;

    @Operation(summary = "Lista todos los proveedores", description = "Devuelve un listado completo de proveedores.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Proveedores listados correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno al listar proveedores")
    })
    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<Suppliers>>> getSuppliers() {
        try {
            List<Suppliers> suppliersList = supplierService.listarSuppliers();

            List<EntityModel<Suppliers>> supplierModels = suppliersList.stream()
                    .map(assembler::toModel)
                    .collect(Collectors.toList());

            CollectionModel<EntityModel<Suppliers>> collectionModel = CollectionModel.of(supplierModels,
                    linkTo(methodOn(SuppliersController.class).getSuppliers()).withSelfRel());

            return ResponseEntity.ok(collectionModel);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Agrega un proveedor", description = "Registra un nuevo proveedor en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Proveedor agregado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos para agregar proveedor"),
            @ApiResponse(responseCode = "500", description = "Error interno al agregar proveedor")
    })
    @PostMapping
    public ResponseEntity<String> postSuppliers(@RequestBody Suppliers suppliers) {
        try {
            String resultado = supplierService.agregarSupplier(suppliers);
            return ResponseEntity.status(201).body(resultado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Datos inválidos para agregar proveedor.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al agregar proveedor.");
        }
    }

    @Operation(summary = "Obtiene un proveedor por ID", description = "Muestra los datos de un proveedor específico según su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Proveedor encontrado correctamente"),
            @ApiResponse(responseCode = "404", description = "Proveedor no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno al consultar proveedor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<String> getSuppliersById(@PathVariable int id) {
        try {
            String proveedor = supplierService.obtenerSupplier(id);
            if (proveedor == null || proveedor.isBlank()) {
                return ResponseEntity.status(404).body("Proveedor no encontrado.");
            }
            return ResponseEntity.ok(proveedor);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al consultar proveedor.");
        }
    }

    @Operation(summary = "Elimina un proveedor por ID", description = "Elimina un proveedor existente en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Proveedor eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Proveedor no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno al eliminar proveedor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSuppliersById(@PathVariable int id) {
        try {
            String resultado = supplierService.eliminarSupplier(id);
            if (resultado.contains("no encontrado")) {
                return ResponseEntity.status(404).body(resultado);
            }
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al eliminar proveedor.");
        }
    }

    @Operation(summary = "Actualiza un proveedor por ID", description = "Modifica los datos de un proveedor existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Proveedor actualizado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos para actualización"),
            @ApiResponse(responseCode = "404", description = "Proveedor no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno al actualizar proveedor")
    })
    @PutMapping("/{id}")
    public ResponseEntity<String> putSuppliersById(@PathVariable int id, @RequestBody Suppliers suppliers) {
        try {
            String resultado = supplierService.actualizarSupplier(id, suppliers);
            if (resultado.contains("no encontrado")) {
                return ResponseEntity.status(404).body(resultado);
            }
            return ResponseEntity.ok(resultado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Datos inválidos para actualizar proveedor.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al actualizar proveedor.");
        }
    }
}
