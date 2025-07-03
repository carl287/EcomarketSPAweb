package com.example.EcomarketSPAweb.assemblers;


import com.example.EcomarketSPAweb.Controller.GestionProductController;
import com.example.EcomarketSPAweb.Model.GestionProduct;
import com.example.EcomarketSPAweb.Model.Product;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class GestionProductAssembler implements RepresentationModelAssembler<GestionProduct, EntityModel<GestionProduct>> {

    @Override
    public EntityModel<GestionProduct> toModel(GestionProduct gestionProduct) {
        return EntityModel.of(gestionProduct,
                linkTo(methodOn(GestionProductController.class).listarProductos()).withRel("productos"),
                linkTo(methodOn(GestionProductController.class).modificarProducto(gestionProduct.getId(), (Product) gestionProduct)).withRel("Modificar"),
                linkTo(methodOn(GestionProductController.class).eliminarProducto(gestionProduct.getId())).withRel("Eliminar"));
    }
}
