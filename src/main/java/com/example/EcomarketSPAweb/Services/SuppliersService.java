package com.example.EcomarketSPAweb.Services;

import com.example.EcomarketSPAweb.Model.Suppliers;
import com.example.EcomarketSPAweb.Repository.SuppliersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuppliersService {
    @Autowired
    SuppliersRepository suppliersRepository;

    public String agregarSupplier(Suppliers supplier){
        suppliersRepository.save(supplier);
        return "Se ha agregado el  con id: "+supplier.getId();

    }
    public List<Suppliers> listarSuppliers(){
        return suppliersRepository.findAll();
    }

    public String obtenerSupplier(int id){
        String output="";
        if (suppliersRepository.existsById(id)){
            Suppliers suppliers=suppliersRepository.findById(id).get();
            output+="ID proveedor: "+suppliers.getId()+"\n";
            output+="Nombre proveedor: "+suppliers.getSupplier_name()+"\n";
            output+="Email proveedor: "+suppliers.getSupplier_email()+"\n";
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
            buscado.setSupplier_name(suppliers.getSupplier_name());
            buscado.setSupplier_email(suppliers.getSupplier_email());
            suppliersRepository.save(buscado);
            return "Se ha actualizado el proveedor con id: "+id;
        }else {
            return "No existe un proveedor con ese id";
        }
    }
}
