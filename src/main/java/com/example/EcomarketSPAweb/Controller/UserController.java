package com.example.EcomarketSPAweb.Controller;

import com.example.EcomarketSPAweb.Model.User;
import com.example.EcomarketSPAweb.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getUsers() {return userService.listarUsuarios();}

    @PostMapping
    public String postUser(@RequestBody User user) {return userService.agregarUser(user);}
}
