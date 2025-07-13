package com.example.EcomarketSPAweb.Controller;

import com.example.EcomarketSPAweb.Model.User;
import com.example.EcomarketSPAweb.Repository.DTO.LoginRequest;
import com.example.EcomarketSPAweb.Services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@Tag(name = "Vista de usuarios")
public class UserController {


    @Autowired
    private UserService userService;

    @Operation(summary = "Lista todos los usuarios", description = "Devuelve un listado de todos los usuarios registrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuarios listados correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno al listar usuarios")
    })
    @GetMapping
    public String getUsers() {
        return userService.listarUsuarios();
    }

    @Operation(summary = "Busca un usuario por ID", description = "Obtiene los datos de un usuario específico según su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario encontrado correctamente"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno al buscar usuario")
    })
    @GetMapping("/id/{id}")
    public String getUserById(@PathVariable int id) {
        return userService.obtenerUsuarioporId(id);
    }

    @Operation(summary = "Inicio de sesión de usuario", description = "Permite que un cliente inicie sesión con su nombre de usuario y contraseña.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Inicio de sesión exitoso"),
            @ApiResponse(responseCode = "401", description = "Credenciales inválidas"),
            @ApiResponse(responseCode = "500", description = "Error interno en el inicio de sesión")
    })
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        Optional<User> user = userService.login(loginRequest.getUsername(), loginRequest.getPassword());

        if (user.isPresent()) {
            return "¡Has iniciado sesión exitosamente!: " + user.get().getUsername();
        } else {
            return "Credenciales inválidas";
        }
    }

}
