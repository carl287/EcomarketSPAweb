package com.example.EcomarketSPAweb.Controller;

import com.example.EcomarketSPAweb.Model.Product;
import com.example.EcomarketSPAweb.Services.GestionProductService;
import com.example.EcomarketSPAweb.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
//probando
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private GestionProductService gestionProductService;

    @GetMapping
    public String getProduct() {return productService.listarProductos();}


    @GetMapping("/{id}")
    public String getProductById(@PathVariable int id) {
        return productService.obtenerProductoPorId(id);
    }



}
