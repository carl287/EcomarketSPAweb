package com.example.EcomarketSPAweb.assemblers;


import com.example.EcomarketSPAweb.Controller.GestionEnvioController;
import com.example.EcomarketSPAweb.Model.GestionEnvio;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class GestionEnvioAssembler implements RepresentationModelAssembler<GestionEnvio, EntityModel<GestionEnvio>>{

    @Override
    public EntityModel<GestionEnvio> toModel(GestionEnvio gestionEnvio) {
        return EntityModel.of(gestionEnvio,
                linkTo(methodOn(GestionEnvioController.class).getGestionEnvioById(gestionEnvio.getId())).withSelfRel(),
                linkTo(methodOn(GestionEnvioController.class).getGestionEnvio()).withRel("gestionEnvio"),
                linkTo(methodOn(GestionEnvioController.class).putGestionEnvioById(gestionEnvio.getId(), gestionEnvio)).withRel("PUT"),
                linkTo(methodOn(GestionEnvioController.class).deleteGestionEnvioById(gestionEnvio.getId())).withRel("DELETE")
                );
    }
}
