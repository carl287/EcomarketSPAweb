package com.example.EcomarketSPAweb.Controller;


import com.example.EcomarketSPAweb.Model.Product;
import com.example.EcomarketSPAweb.Model.Shipping;
import com.example.EcomarketSPAweb.Services.ProductService;
import com.example.EcomarketSPAweb.Services.ShippingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shippings")
@Tag(name = "Vista de envios")

public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @GetMapping
    @Operation(summary = "Se listan los productos")
    public String getShipping(){
        return shippingService.listarShipping();
    }

    @PostMapping
    @Operation(summary = "Se agrega un envio, esto hay que borrarlo ya que esta en gestion de envios")
    public String postShipping(@RequestBody Shipping shipping){
        return shippingService.agregarShipping(shipping);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Se consulta un producto por ña busqueda de id")
    public String getShippingById(@PathVariable int id){
        return shippingService.obtenerShippingPorId(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Se borra un envio, esto hay que borrarlo ya que esta en gestion de envios")
    public String deleteShippingById(@PathVariable int id){
        return shippingService.eliminarShipping(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Se modifca un producto, esto hay que borrarlo ya que esta en gestion de envios")
    public String putShippingById(@PathVariable int id, @RequestBody Shipping shipping){
        return shippingService.actualizarShipping(id,shipping);
    }

}
