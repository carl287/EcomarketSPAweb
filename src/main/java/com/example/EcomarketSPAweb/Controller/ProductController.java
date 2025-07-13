package com.example.EcomarketSPAweb.Controller;

import com.example.EcomarketSPAweb.Model.Product;
import com.example.EcomarketSPAweb.Services.GestionProductService;
import com.example.EcomarketSPAweb.Services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@Tag(name = "Vista de productos")
//probando
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private GestionProductService gestionProductService;

    @Operation(summary = "Lista todos los productos", description = "Devuelve un listado completo de productos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Productos listados correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno al listar productos")
    })
    @GetMapping
    public ResponseEntity<String> getProduct() {
        try {
            String productos = productService.listarProductos();
            return ResponseEntity.ok(productos); // 200 OK
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al listar productos.");
        }
    }

    @Operation(summary = "Obtiene un producto por su ID", description = "Busca un producto específico según su identificador.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto encontrado correctamente"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno al buscar producto")
    })
    @GetMapping("/{id}")
    public ResponseEntity<String> getProductById(@PathVariable int id) {
        try {
            String producto = productService.obtenerProductoPorId(id);

            // Validación simple: si la respuesta está vacía, lo tratamos como "no encontrado"
            if (producto == null || producto.isBlank()) {
                return ResponseEntity.status(404).body("Producto no encontrado.");
            }

            return ResponseEntity.ok(producto); // 200 OK

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al buscar producto.");
        }
    }

}
