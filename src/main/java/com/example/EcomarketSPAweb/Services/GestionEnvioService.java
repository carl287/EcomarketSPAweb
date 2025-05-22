package com.example.EcomarketSPAweb.Services;

import com.example.EcomarketSPAweb.Model.GestionEnvio;
import com.example.EcomarketSPAweb.Repository.GestionEnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class GestionEnvioService {
    @Autowired
    GestionEnvioRepository gestionEnvioRepository;

    public String agregarGestionEnvio(GestionEnvio gestionEnvio) {
        gestionEnvioRepository.save(gestionEnvio);
        return "Se ha agregado el envio con id: "+gestionEnvio.getId();
    }

    public String listarGestionEnvio(){
        String output="";
        for(GestionEnvio gestionEnvio:gestionEnvioRepository.findAll()){
            output+="ID envio: "+gestionEnvio.getId()+"\n";
            output+="Nombre envio: "+gestionEnvio.getGestionName()+"\n";
            output+="Email envio: "+gestionEnvio.getGestionEmail()+"\n";
            output+="Patente envio: "+gestionEnvio.getGestionPatente()+"\n";
        }

        if (output.isEmpty()){
            return "No hay envios";

        }else {
            return output;
        }
    }
    public String obtenerGestionEnvioPorId(int id){
        String output="";
        if (gestionEnvioRepository.existsById(id)){
            GestionEnvio gestionEnvio=gestionEnvioRepository.findById(id).get();
            output+="ID envio: "+gestionEnvio.getId()+"\n";
            output+="Nombre envio: "+gestionEnvio.getGestionName()+"\n";
            output+="Email envio: "+gestionEnvio.getGestionEmail()+"\n";
            output+="Patente envio: "+gestionEnvio.getGestionPatente()+"\n";
            return output;
        }else{
            return "No existe un envio con ese id";
        }
    }

    public String eliminarGestionEnvio(int id){
        if (gestionEnvioRepository.existsById(id)){
            gestionEnvioRepository.deleteById(id);
            return "Se ha eliminado el envio con id: "+id;
        }else{
            return "No existe un envio con ese id";
        }
    }

    public String actualizarGestionEnvio(int id, GestionEnvio gestionEnvio){
        if (gestionEnvioRepository.existsById(id)){
            GestionEnvio buscado=gestionEnvioRepository.findById(id).get();
            buscado.setGestionName(gestionEnvio.getGestionName());
            buscado.setGestionEmail(gestionEnvio.getGestionEmail());
            buscado.setGestionPatente(gestionEnvio.getGestionPatente());
            gestionEnvioRepository.save(buscado);
            return "Se ha actualizado el envio con id: "+id;
        }else {
            return "No existe un envio con ese id";
        }
    }



}
