package com.example.EcomarketSPAweb.Services;

import com.example.EcomarketSPAweb.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserService {

    @Autowired
    UserRepository userRepository;

    public String agregarUser(User user){
        userRepository.save(user);
        return "se a agregado usuario con id "+user.getId();
    }

    public String listarUsuarios() {
        String output= "";
        for(Usuario usuario:UserRepository.findall);
    }
}
