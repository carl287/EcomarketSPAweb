package com.example.EcomarketSPAweb.Controller;

import com.example.EcomarketSPAweb.Model.Product;
import com.example.EcomarketSPAweb.Services.GestionProductService;
import com.example.EcomarketSPAweb.Services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    @Operation(summary = "Se lista todos los productos")
    public String getProduct() {return productService.listarProductos();}


    @GetMapping("/{id}")
    @Operation(summary = "Se busca el producto por id")
    public String getProductById(@PathVariable int id) {
        return productService.obtenerProductoPorId(id);
    }



}
