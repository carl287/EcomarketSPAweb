package com.example.EcomarketSPAweb.Controller;

import com.example.EcomarketSPAweb.Model.Suppliers;
import com.example.EcomarketSPAweb.Services.SuppliersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/suppliers")
@Tag(name = "Administracion y gestion de proovedores")
public class SuppliersController {

    @Autowired
    private SuppliersService supplierService;

    @GetMapping
    @Operation(summary = "Se lista los proovedores")
    public String getSuppliers() {
        return supplierService.listarSuppliers();
    }

    @PostMapping
    @Operation(summary = "Se agrega un proovedor")
    public String postSuppliers(@RequestBody Suppliers suppliers) {
        return supplierService.agregarSupplier(suppliers);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Se muestra el proovedor por su id")
    public String getSuppliersById(@PathVariable int id) {
        return supplierService.obtenerSupplier(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Se elimina el proovedor por id")
    public String deleteSuppliersById(@PathVariable int id) {
        return supplierService.eliminarSupplier(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Se actualizan los datos de proovedor por su id")
    public String putSuppliersById(@PathVariable int id, @RequestBody Suppliers suppliers) {
        return supplierService.actualizarSupplier(id, suppliers);
    }
}
