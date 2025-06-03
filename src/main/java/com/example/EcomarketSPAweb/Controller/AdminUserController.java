package com.example.EcomarketSPAweb.Controller;


import com.example.EcomarketSPAweb.Model.*;
import com.example.EcomarketSPAweb.Repository.*;
import com.example.EcomarketSPAweb.Services.AdminUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/admin")
@Tag(name = "Administracion de usuarios para Admin/Encargado", description = "Operaciones que puede hacer el administrador o encargado para administrar usuarios")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    // Listar todos los usuarios
    // http://localhost:8080/users/admin (GET)
    @GetMapping
    @Operation(summary = "obtiene una lista con todos los usarios registrados")
    public List<User> listarUsuarios() {
        return adminUserService.obtenerTodosLosUsuarios();
    }


    // Agregar usuario en el postman http://localhost:8080/users/admin (POST-BODY-RAW-JSON)
    // {
    //  "username": "nombre",
    //  "email": "correo",
    //  "password": "contraseña"
    //}
    @PostMapping
    @Operation(summary = "se agrega un usario manualmente")
    public ResponseEntity<User> agregarUsuario(@RequestBody User nuevoUsuario) {
        User creado = adminUserService.agregarUsuario(nuevoUsuario);
        return ResponseEntity.ok(creado);
    }

    // Modificar usuario
    // http://localhost:8080/users/admin/(id) (PUT-BODY-RAW-JSON)
    //   "username": "nombre_actualizado",
    //  "email": "correo.actualizado@mail.com",
    //  "password": "nuevaclave"
    //}
    @PutMapping("/{id}")
    @Operation(summary = "se modifica el usuario ya registrado")
    public ResponseEntity<User> modificarUsuario(@PathVariable int id, @RequestBody User usuario) {
        try {
            User actualizado = adminUserService.modificarUsuario(id, usuario);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Desactiva usuario
    // http://localhost:8080/users/admin/(id)/desactivar (PUT)
    @PutMapping("/{id}/desactivar")
    @Operation(summary = "se desactiva un usuario ya registrado")
    public ResponseEntity<String> desactivarUsuario(@PathVariable int id) {
        try {
            adminUserService.desactivarUsuario(id);
            return ResponseEntity.ok("Usuario desactivado.");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }



    // Eliminar usuario
    // http://localhost:8080/users/admin/(id) (DELETE)
    @DeleteMapping("/{id}")
    @Operation(summary = "se elimina el usuario ya registrado por completo, se recomienda desactivar usuario")
    public ResponseEntity<String> eliminarUsuario(@PathVariable int id) {
        try {
            adminUserService.eliminarUsuarioPorId(id);
            return ResponseEntity.ok("Usuario eliminado.");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
