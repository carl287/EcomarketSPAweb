package com.example.EcomarketSPAweb.Controller;

import com.example.EcomarketSPAweb.Model.Product;
import com.example.EcomarketSPAweb.Model.User;
import com.example.EcomarketSPAweb.Services.ProductService;
import com.example.EcomarketSPAweb.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
//probando
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String getProduct() {return productService.listarProductos();}

    @PostMapping
    public String postProduct(@RequestBody Product product) {return productService.agregarProducto(product);}

    @GetMapping("/id")
    public String getProductById(@PathVariable int id) {
        return productService.obtenerProductoPorId(id);
    }

}
