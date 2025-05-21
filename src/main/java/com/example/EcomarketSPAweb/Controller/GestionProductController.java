package com.example.EcomarketSPAweb.Controller;

import com.example.EcomarketSPAweb.Model.Product;
import com.example.EcomarketSPAweb.Model.User;
import com.example.EcomarketSPAweb.Services.AdminUserService;
import com.example.EcomarketSPAweb.Services.GestionProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestionproduct")
public class GestionProductController {

    @Autowired
    private GestionProductService gestionProductService;

    // Listar todos
    @GetMapping
    public List<Product> listarProductos() {
        return gestionProductService.obtenerTodosLosProductos();
    }

    // Agregar Producto
    @PostMapping
    public ResponseEntity<Product> agregarProducto(@RequestBody Product nuevoProducto) {
        Product creado = gestionProductService.agregarProducto(nuevoProducto);
        return ResponseEntity.ok(creado);
    }

    // Modificar Producto
    @PutMapping("/id")
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
    public ResponseEntity<String> eliminarProducto(@PathVariable int id) {
        try {
            gestionProductService.eliminarProductoPorId(id);
            return ResponseEntity.ok("Producto eliminado.");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
