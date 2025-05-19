package com.example.EcomarketSPAweb.Services;

import com.example.EcomarketSPAweb.Model.Suppliers;
import com.example.EcomarketSPAweb.Repository.SuppliersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuppliersService {
    @Autowired
    SuppliersRepository suppliersRepository;

    public String agregarSupplier(Suppliers supplier){
        suppliersRepository.save(supplier);
        return "Se ha agregado el  con id: "+supplier.getId();

    }
    public String listarSuppliers(){
        String output="";
        for(Suppliers suppliers:suppliersRepository.findAll()){
            output+="ID proveedor: "+suppliers.getId()+"\n";
            output+="Nombre proveedor: "+suppliers.getSupplierName()+"\n";
            output+="Email proveedor: "+suppliers.getSupplierEmail()+"\n";
        }

        if (output.isEmpty()){
            return "No hay proveedores";

        }else {
            return output;
        }
    }

    public String obtenerSupplier(int id){
        String output="";
        if (suppliersRepository.existsById(id)){
            Suppliers suppliers=suppliersRepository.findById(id).get();
            output+="ID proveedor: "+suppliers.getId()+"\n";
            output+="Nombre proveedor: "+suppliers.getSupplierName()+"\n";
            output+="Email proveedor: "+suppliers.getSupplierEmail()+"\n";
            return output;
        }else{
            return "No existe un proveedor con ese id";
        }
    }
    public String eliminarSupplier(int id){
        if (suppliersRepository.existsById(id)){
            suppliersRepository.deleteById(id);
            return "Se ha eliminado el proveedor con id: "+id;
        }else{
            return "No existe un proveedor con ese id";
        }
    }

    public String actualizarSupplier(int id, Suppliers suppliers){
        if (suppliersRepository.existsById(id)){
            Suppliers buscado=suppliersRepository.findById(id).get();
            buscado.setSupplierName(suppliers.getSupplierName());
            buscado.setSupplierEmail(suppliers.getSupplierEmail());
            suppliersRepository.save(buscado);
            return "Se ha actualizado el proveedor con id: "+id;
        }else {
            return "No existe un proveedor con ese id";
        }
    }
}
