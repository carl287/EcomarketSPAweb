package com.example.EcomarketSPAweb.Controller;


import com.example.EcomarketSPAweb.Model.Product;
import com.example.EcomarketSPAweb.Model.Shipping;
import com.example.EcomarketSPAweb.Services.ProductService;
import com.example.EcomarketSPAweb.Services.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shippings")

public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @GetMapping
    public String getShipping(){
        return shippingService.listarShipping();
    }

    @PostMapping
    public String postShipping(@RequestBody Shipping shipping){
        return shippingService.agregarShipping(shipping);
    }

    @GetMapping("/{id}")
    public String getShippingById(@PathVariable int id){
        return shippingService.obtenerShippingPorId(id);
    }

    @DeleteMapping("/{id}")
    public String deleteShippingById(@PathVariable int id){
        return shippingService.eliminarShipping(id);
    }

    @PutMapping("/{id}")
    public String putShippingById(@PathVariable int id, @RequestBody Shipping shipping){
        return shippingService.actualizarShipping(id,shipping);
    }

}
