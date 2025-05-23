package com.example.EcomarketSPAweb.Services;

import com.example.EcomarketSPAweb.Model.Product;
import com.example.EcomarketSPAweb.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public String agregarProducto(Product product){
        productRepository.save(product);
        return "Se ha agregado el producto con id: "+product.getId();
    }

    public String listarProductos(){
        String output="";
        for(Product product:productRepository.findAll()){
            output+="ID producto: "+product.getId()+"\n";
            output+="Nombre producto: "+product.getName()+"\n";
            output+="Descripcion producto: "+product.getDescription()+"\n";
            output+="Stock producto: "+product.getStock()+"\n";
        }

        if (output.isEmpty()){
            return "No hay productos";

        }else {
            return output;
        }
    }

    public String obtenerProductoPorId(int id){
        String output="";
        if (productRepository.existsById(id)){
            Product product=productRepository.findById(id).get();
            output+="ID producto: "+product.getId()+"\n";
            output+="Nombre producto: "+product.getName()+"\n";
            output+="Descripcion producto: "+product.getDescription()+"\n";
            output+="Stock producto: "+product.getStock()+"\n";
            return output;
        }else{
            return "No existe un producto con ese id";
        }
    }

}
