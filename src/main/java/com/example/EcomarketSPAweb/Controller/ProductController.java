package com.example.EcomarketSPAweb.Controller;

import com.example.EcomarketSPAweb.Model.Product;
import com.example.EcomarketSPAweb.Services.GestionProductService;
import com.example.EcomarketSPAweb.Services.ProductService;
import com.example.EcomarketSPAweb.assemblers.ProductModelAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Tag(name = "Vista de productos")
//probando
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private GestionProductService gestionProductService;

    @Autowired
    ProductModelAssembler assembler;

    @Operation(summary = "Lista todos los productos", description = "Devuelve un listado completo de productos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Productos listados correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno al listar productos")
    })
    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<Product>>> getProduct() {
        List<Product> lista = productService.listarProductos();
        if (lista.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(assembler.toCollectionModel(lista), HttpStatus.OK);
        }
    }

    @Operation(summary = "Obtiene un producto por su ID", description = "Busca un producto específico según su identificador.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto encontrado correctamente"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno al buscar producto")
    })
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Product>> getProductById(@PathVariable int id) {
        Product product = productService.obtenerProductoPorId(id);
        if (productService.obtenerProductoPorId(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(assembler.toModel(product), HttpStatus.OK);
        }
    }

}
