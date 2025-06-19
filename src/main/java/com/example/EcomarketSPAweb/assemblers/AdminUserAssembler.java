package com.example.EcomarketSPAweb.assemblers;

import com.example.EcomarketSPAweb.Controller.AdminUserController;
import com.example.EcomarketSPAweb.Model.AdminUser;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AdminUserAssembler  implements RepresentationModelAssembler<AdminUser, EntityModel<AdminUser>> {
    @Override
    public EntityModel<AdminUser> toModel(AdminUser adminUser) {
        return EntityModel.of(adminUser,
                linkTo(methodOn(AdminUserController.class).listarUsuarios()).withRel("Usuarios"),
                linkTo(methodOn(AdminUserController.class).modificarUsuario(adminUser.getId(), adminUser)).withRel("Modificar"),
                linkTo(methodOn(AdminUserController.class).eliminarUsuario(adminUser.getId())).withRel("Eliminar")
                );
    }
}
