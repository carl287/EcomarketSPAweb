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

    public String eliminarProducto(int id){
        if (productRepository.existsById(id)){
            productRepository.deleteById(id);
            return "Se ha eliminado el producto con id: "+id;
        }else{
            return "No existe un producto con ese id";
        }
    }

    public String actualizarProducto(int id, Product product){
        if (productRepository.existsById(id)){
            Product buscado=productRepository.findById(id).get();
            buscado.setName(product.getName());
            buscado.setDescription(product.getDescription());
            buscado.setPrice(product.getPrice());
            buscado.setStock(product.getStock());
            productRepository.save(buscado);
            return "Se ha actualizado el producto con id: "+id;
        }else {
            return "No existe un producto con ese id";
        }
    }
}
