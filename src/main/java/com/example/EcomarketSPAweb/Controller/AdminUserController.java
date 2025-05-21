package com.example.EcomarketSPAweb.Controller;


import com.example.EcomarketSPAweb.Model.*;
import com.example.EcomarketSPAweb.Repository.*;
import com.example.EcomarketSPAweb.Services.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    // Listar todos
    @GetMapping
    public List<User> listarUsuarios() {
        return adminUserService.obtenerTodosLosUsuarios();
    }

    // Agregar usuario
    @PostMapping
    public ResponseEntity<User> agregarUsuario(@RequestBody User nuevoUsuario) {
        User creado = adminUserService.agregarUsuario(nuevoUsuario);
        return ResponseEntity.ok(creado);
    }

    // Modificar usuario
    @PutMapping("/{id}")
    public ResponseEntity<User> modificarUsuario(@PathVariable int id, @RequestBody User usuario) {
        try {
            User actualizado = adminUserService.modificarUsuario(id, usuario);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Desactivar usuario
    @PutMapping("/{id}/desactivar")
    public ResponseEntity<String> desactivarUsuario(@PathVariable int id) {
        try {
            adminUserService.desactivarUsuario(id);
            return ResponseEntity.ok("Usuario desactivado.");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar usuario
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
