package com.example.EcomarketSPAweb.Services;


import com.example.EcomarketSPAweb.Model.Shipping;
import com.example.EcomarketSPAweb.Repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ShippingService {

    @Autowired
    ShippingRepository shippingRepository;

    public String agregarShipping(Shipping shipping){
        shippingRepository.save(shipping);
        return "Se ha agregado el envio con id: "+shipping.getId();
    }

    public String listarShipping(){
        String output="";
        for(Shipping shipping:shippingRepository.findAll()){
            output+="ID envio: "+shipping.getId()+"\n";
            output+="Nombre envio: "+shipping.getShipping_name()+"\n";
            output+="Email envio: "+shipping.getShipping_email()+"\n";
            output+="Patente envio: "+shipping.getPatente()+"\n";
        }

        if (output.isEmpty()){
            return "No hay envios";

        }else {
            return output;
        }
    }

    public String obtenerShippingPorId(int id){
        String output="";
        if (shippingRepository.existsById(id)){
            Shipping shipping=shippingRepository.findById(id).get();
            output+="ID envio: "+shipping.getId()+"\n";
            output+="Nombre envio: "+shipping.getShipping_name()+"\n";
            output+="Email envio: "+shipping.getShipping_email()+"\n";
            output+="Patente envio: "+shipping.getPatente()+"\n";
            return output;
        }else{
            return "No existe un envio con ese id";
        }
    }

    public String eliminarShipping(int id){
        if (shippingRepository.existsById(id)){
            shippingRepository.deleteById(id);
            return "Se ha eliminado el envio con id: "+id;
        }else{
            return "No existe un envio con ese id";
        }
    }

    public String actualizarShipping(int id, Shipping shipping){
        if (shippingRepository.existsById(id)){
            Shipping buscado=shippingRepository.findById(id).get();
            buscado.setShipping_name(shipping.getShipping_name());
            buscado.setShipping_email(shipping.getShipping_email());
            buscado.setPatente(shipping.getPatente());
            shippingRepository.save(buscado);
            return "Se ha actualizado el envio con id: "+id;
        }else {
            return "No existe un envio con ese id";
        }
    }
}
