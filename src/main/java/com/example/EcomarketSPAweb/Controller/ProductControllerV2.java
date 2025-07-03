package com.example.EcomarketSPAweb.Controller;


import com.example.EcomarketSPAweb.Services.GestionProductService;
import com.example.EcomarketSPAweb.Services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//V2 DE PRODUCT CONTROLLER

@RestController
@RequestMapping("/api/v2/products")
public class ProductControllerV2 {
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
