package com.example.EcomarketSPAweb.Controller;

import com.example.EcomarketSPAweb.Model.User;
import com.example.EcomarketSPAweb.Repository.DTO.LoginRequest;
import com.example.EcomarketSPAweb.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getUsers() {
        return userService.listarUsuarios();
    }

    @GetMapping("/id/{id}")
    public String getUserById(@PathVariable int id) {
        return userService.obtenerUsuarioporId(id);
    }

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
