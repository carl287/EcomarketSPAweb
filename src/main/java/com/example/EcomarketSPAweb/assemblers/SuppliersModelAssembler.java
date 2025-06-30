package com.example.EcomarketSPAweb.assemblers;

import com.example.EcomarketSPAweb.Controller.SuppliersController;
import com.example.EcomarketSPAweb.Model.Suppliers;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class SuppliersModelAssembler implements RepresentationModelAssembler<Suppliers, EntityModel<Suppliers>> {

    @Override
    public EntityModel<Suppliers> toModel(Suppliers suppliers) {
        return EntityModel.of(suppliers,
                linkTo(methodOn(SuppliersController.class).getSuppliersById(suppliers.getId())).withSelfRel(),
                linkTo(methodOn(SuppliersController.class).getSuppliers()).withRel("suppliers")
        );
    }
}