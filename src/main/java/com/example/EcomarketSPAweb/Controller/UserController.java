package com.example.EcomarketSPAweb.Controller;


import com.example.EcomarketSPAweb.Services.UserService;
import com.example.EcomarketSPAweb.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/users")
public class UserController {

        @Autowired
        UserService userService;

        @GetMapping
        public String getUsers(){
            return userService.geUsers();
        }

        @PostMapping
        public String addUser(@RequestBody User user){
            return userService.addUser(user);
        }

        @GetMapping("/{id}")
        public String getUserById(@PathVariable int id){
            return userService.getUser(id);
        }

        @DeleteMapping("/{id}")
        public String deleteUser(@PathVariable int id){
            return userService.deleteUser(id);
        }
        @PutMapping("/{id}")
        public String putUserById(@PathVariable int id, @RequestBody User user){
            return userService.updateUser(id,user);
        }


}
