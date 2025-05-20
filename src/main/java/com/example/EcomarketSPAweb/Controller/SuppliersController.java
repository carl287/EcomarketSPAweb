package com.example.EcomarketSPAweb.Controller;

import com.example.EcomarketSPAweb.Model.Suppliers;
import com.example.EcomarketSPAweb.Services.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/suppliers")

public class SuppliersController {
    @Autowired
    private SuppliersService supplierService;

    @GetMapping
    public String getSuppliers() {
        return supplierService.listarSuppliers();
    }

    @PostMapping
    public String postSuppliers(@RequestBody Suppliers suppliers) {
        return supplierService.agregarSupplier(suppliers);
    }

    @GetMapping("/{id}")
    public String getSupplierById(@PathVariable int id) {
        return supplierService.obtenerSupplier(id);
    }

    @DeleteMapping("/{id}")
    public String deleteSupplierById(@PathVariable int id) {
        return supplierService.eliminarSupplier(id);
    }

    @PutMapping("/{id}")
    public String putSupplierById(@PathVariable int id, @RequestBody Suppliers suppliers) {
        return supplierService.actualizarSupplier(id, suppliers);
    }
}
