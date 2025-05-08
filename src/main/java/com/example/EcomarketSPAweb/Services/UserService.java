package com.example.EcomarketSPAweb.Services;

import com.example.EcomarketSPAweb.Model.User;
import com.example.EcomarketSPAweb.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UsersRepository usersRepository;

    public String geUsers(){return usersRepository.getUsers();}

    public String addUser(User user){return usersRepository.addUser(user);}

    public String getUser(int id) { return usersRepository.getUser(id);}

    public String deleteUser(int id) { return usersRepository.removeUser(id);}

    public String updateUser(int id, User user) {return usersRepository.updateUser(id,user);}
}
