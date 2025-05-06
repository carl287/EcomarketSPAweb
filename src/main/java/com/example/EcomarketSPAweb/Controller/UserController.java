package com.example.EcomarketSPAweb.Controller;


import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("/users")
public class UserController {

        @Autowired
        UserService userService;

        @GetMapping
        public String getUsers(){
            return userService.getUsers();
        }

        @PostMapping
        public String addUser(@RequestBody User user){
            return userService.addUser(user);
        }

        @GetMapping("/{id}")
        public String getUserById(@PathVariable int id){
            return userService.getuser(id);
        }


}
