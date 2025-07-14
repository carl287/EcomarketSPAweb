package com.example.EcomarketSPAweb.Services;

import com.example.EcomarketSPAweb.Model.Product;
import com.example.EcomarketSPAweb.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public String agregarProducto(Product product){
        productRepository.save(product);
        return "Se ha agregado el producto con id: "+product.getId();
    }

    public List<Product> listarProductos(){
        return productRepository.findAll();
    }

    public Product obtenerProductoPorId(int id){
        if (productRepository.existsById(id)){
            return productRepository.findById(id).get();
        }
        return null;
    }

}
