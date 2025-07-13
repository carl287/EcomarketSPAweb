package com.example.EcomarketSPAweb.Controller;


import com.example.EcomarketSPAweb.Model.*;
import com.example.EcomarketSPAweb.Repository.*;
import com.example.EcomarketSPAweb.Services.AdminUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Obtiene todos los usuarios", description = "Devuelve una lista con todos los usuarios registrados en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuarios listados correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno al obtener usuarios")
    })
    @GetMapping
    public List<User> listarUsuarios() {
        return adminUserService.obtenerTodosLosUsuarios();
    }

    @Operation(summary = "Agrega un usuario manualmente", description = "Registra un nuevo usuario con sus datos básicos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario agregado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos para crear usuario"),
            @ApiResponse(responseCode = "500", description = "Error interno al agregar usuario")
    })
    @PostMapping
    public ResponseEntity<User> agregarUsuario(@RequestBody User nuevoUsuario) {
        User creado = adminUserService.agregarUsuario(nuevoUsuario);
        return ResponseEntity.ok(creado);
    }

    @Operation(summary = "Modifica un usuario existente", description = "Actualiza los datos de un usuario según su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario modificado correctamente"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos para actualización"),
            @ApiResponse(responseCode = "500", description = "Error interno al modificar usuario")
    })
    @PutMapping("/{id}")
    public ResponseEntity<User> modificarUsuario(@PathVariable int id, @RequestBody User usuario) {
        try {
            User actualizado = adminUserService.modificarUsuario(id, usuario);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Desactiva un usuario", description = "Desactiva lógicamente un usuario por su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario desactivado correctamente"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno al desactivar usuario")
    })
    @PutMapping("/{id}/desactivar")
    public ResponseEntity<String> desactivarUsuario(@PathVariable int id) {
        try {
            adminUserService.desactivarUsuario(id);
            return ResponseEntity.ok("Usuario desactivado.");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Elimina un usuario permanentemente", description = "Elimina completamente un usuario del sistema por su ID. Se recomienda desactivar en lugar de eliminar si no es necesario borrar datos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno al eliminar usuario")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable int id) {
        try {
            adminUserService.eliminarUsuarioPorId(id);
            return ResponseEntity.ok("Usuario eliminado.");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
