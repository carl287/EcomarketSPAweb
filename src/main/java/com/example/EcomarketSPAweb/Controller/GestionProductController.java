package com.example.EcomarketSPAweb.Controller;

import com.example.EcomarketSPAweb.Model.Product;
import com.example.EcomarketSPAweb.Services.GestionProductService;
import io.swagger.v3.oas.annotations.Operation;
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

    // Listar todos
    @GetMapping
    @Operation(summary = "se lista los productos")
    public List<Product> listarProductos() {
        return gestionProductService.obtenerTodosLosProductos();
    }

    // Agregar Producto
    @PostMapping
    @Operation(summary = "Se agrega producto")
    public ResponseEntity<Product> agregarProducto(@RequestBody Product nuevoProducto) {
        Product creado = gestionProductService.agregarProducto(nuevoProducto);
        return ResponseEntity.ok(creado);
    }

    // Modificar Producto
    @PutMapping("/{id}")
    @Operation(summary = "Se modifica el producto por su id")
    public ResponseEntity<Product> modificarProducto(@PathVariable int id, @RequestBody Product producto) {
        try {
            Product actualizado = gestionProductService.modificarProducto(id, producto);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar Producto
    @DeleteMapping("/{id}")
    @Operation(summary = "Se elimina el producto por su id")
    public ResponseEntity<String> eliminarProducto(@PathVariable int id) {
        try {
            gestionProductService.eliminarProductoPorId(id);
            return ResponseEntity.ok("Producto eliminado.");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }



}
