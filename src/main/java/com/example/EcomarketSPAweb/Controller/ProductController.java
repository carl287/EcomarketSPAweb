package com.example.EcomarketSPAweb.Controller;

import com.example.EcomarketSPAweb.Model.Product;
import com.example.EcomarketSPAweb.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")

public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String getProducts(){
        return productService.listarProductos();
    }

    @PostMapping
    public String postProduct(@RequestBody Product product){
        return productService.agregarProducto(product);
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable int id){
        return productService.obtenerProductoPorId(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable int id){
        return productService.eliminarProducto(id);
    }

    @PutMapping("/{id}")
    public String putProductById(@PathVariable int id, @RequestBody Product product){
        return productService.actualizarProducto(id,product);
    }
}
