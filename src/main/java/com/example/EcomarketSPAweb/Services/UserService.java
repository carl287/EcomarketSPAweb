package com.example.EcomarketSPAweb.Services;

import com.example.EcomarketSPAweb.Model.User;
import com.example.EcomarketSPAweb.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {

    @Autowired
    UserRepository userRepository;

    public String agregarUser(User user) {
        userRepository.save(user);
        return "se a agregado usuario con id " + user.getId();
    }

    public List<User> listarUsuarios() {
        return userRepository.findAll();
    }

    public User obtenerUsuarioporId(int id) {
        if (userRepository.existsById(id)) {
            return userRepository.findById(id).get();
        }
        return null;
    }

    public String eliminarUsuario(int id){
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return "Se ha eliminado el producto con id: "+id;
        }else{
            return "No existe un producto con ese id";
        }
    }

    public String actualizarUsuario(int id, User user){
        if (userRepository.existsById(id)){
            User buscado=userRepository.findById(id).get();
            buscado.setUsername(user.getUsername());
            buscado.setPassword(user.getPassword());
            buscado.setEmail(user.getEmail());
            userRepository.save(buscado);
            return "Se ha actualizado el usuario con id: "+id;
        }else {
            return "No existe un usuario con ese id";
        }
    }

    public Optional<User> login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
