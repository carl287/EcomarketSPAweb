package com.example.EcomarketSPAweb.Controller;

import com.example.EcomarketSPAweb.Model.Product;
import com.example.EcomarketSPAweb.Services.GestionProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/gestion")
@Tag(name = "Gestion de productos")
public class GestionProductController {

    @Autowired
    private GestionProductService gestionProductService;

    @Operation(summary = "Lista todos los productos", description = "Devuelve una lista con todos los productos disponibles.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Productos listados correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno al obtener los productos")
    })
    @GetMapping
    public ResponseEntity<List<Product>> listarProductos() {
        try {
            List<Product> productos = gestionProductService.obtenerTodosLosProductos();
            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Agrega un producto", description = "Registra un nuevo producto en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto agregado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos para crear producto"),
            @ApiResponse(responseCode = "500", description = "Error interno al agregar producto")
    })
    @PostMapping
    public ResponseEntity<Product> agregarProducto(@RequestBody Product nuevoProducto) {
        try {
            Product creado = gestionProductService.agregarProducto(nuevoProducto);
            return ResponseEntity.ok(creado);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    @Operation(summary = "Modifica un producto", description = "Actualiza los datos de un producto según su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto modificado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos para actualización"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno al modificar producto")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Product> modificarProducto(@PathVariable int id, @RequestBody Product producto) {
        try {
            Product actualizado = gestionProductService.modificarProducto(id, producto);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Elimina un producto", description = "Elimina completamente un producto del sistema por su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno al eliminar producto")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable int id) {
        try {
            gestionProductService.eliminarProductoPorId(id);
            return ResponseEntity.ok("Producto eliminado.");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
