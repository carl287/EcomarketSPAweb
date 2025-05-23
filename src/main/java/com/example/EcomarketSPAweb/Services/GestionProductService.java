package com.example.EcomarketSPAweb.Services;

import com.example.EcomarketSPAweb.Model.Product;
import com.example.EcomarketSPAweb.Model.User;
import com.example.EcomarketSPAweb.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GestionProductService {

    @Autowired
    private ProductRepository productRepository;

    // Listar todos los prodcutos
    public List<Product> obtenerTodosLosProductos() {
        return productRepository.findAll();
    }

    // Agregar Producto
    public Product agregarProducto(Product nuevoProducto) {
        return productRepository.save(nuevoProducto);
    }

    // Modificar Producto
    public Product modificarProducto(int id, Product datosActualizados) {
        Optional<Product> producto = productRepository.findById(id);
        if (producto.isPresent()) {
            Product existente = producto.get();
            existente.setStock(datosActualizados.getStock());
            existente.setName(datosActualizados.getName());
            existente.setDescription(datosActualizados.getDescription());
            return productRepository.save(existente);
        } else {
            throw new RuntimeException("Producto encontrado con ID: " + id);
        }
    }

    // Se elimina el producto por id
    public void eliminarProductoPorId(int id) {
        Optional<Product> producto = productRepository.findById(id);
        if (producto.isPresent()) {
            productRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
    }
}
