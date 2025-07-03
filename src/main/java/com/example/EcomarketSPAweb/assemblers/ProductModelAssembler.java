package com.example.EcomarketSPAweb.assemblers;


import com.example.EcomarketSPAweb.Controller.ProductController;
import com.example.EcomarketSPAweb.Model.GestionProduct;
import com.example.EcomarketSPAweb.Model.Product;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductModelAssembler implements RepresentationModelAssembler<Product, EntityModel<Product>> {
    @Override
    public EntityModel<Product> toModel(Product product) {
        //se pone solo los metodos de get porque los metodos de delete, agregar y modificar estan en GestionProduct
        return EntityModel.of(product,
                linkTo(methodOn(ProductController.class).getProductById(product.getId())).withSelfRel(),
                linkTo(methodOn(ProductController.class).getProduct()).withRel("product")
        );
    }

}
