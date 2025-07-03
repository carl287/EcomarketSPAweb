package com.example.EcomarketSPAweb.assemblers;


import com.example.EcomarketSPAweb.Controller.ShippingController;
import com.example.EcomarketSPAweb.Model.Shipping;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ShippingModelAssembler implements RepresentationModelAssembler<Shipping, EntityModel<Shipping>> {

    @Override
    public EntityModel<Shipping> toModel(Shipping shipping) {
        return EntityModel.of(shipping,
                linkTo(methodOn(ShippingController.class).getShippingById(shipping.getId())).withSelfRel(),
                linkTo(methodOn(ShippingController.class).getShipping()).withRel("shipping")
                );
    }
}
