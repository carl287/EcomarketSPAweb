package com.example.EcomarketSPAweb.Services;

import com.example.EcomarketSPAweb.Model.Product;
import com.example.EcomarketSPAweb.Model.User;
import com.example.EcomarketSPAweb.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserService {

    @Autowired
    UserRepository userRepository;

    public String agregarUser(User user) {
        userRepository.save(user);
        return "se a agregado usuario con id " + user.getId();
    }

    public String listarUsuarios() {
        String output = "";
        for (User user : userRepository.findAll()) {
            output += "Id usuario: " + user.getId() + "\n";
            output += "nombre de usuario: " + user.getUsername() + "\n";
            output += "contraseña: " + user.getPassword() + "\n";
            output += "correo: " + user.getPassword() + "\n";
        }
        if (output.isEmpty()) {
            return "no hay usuarios";
        } else {
            return output;
        }
    }

    public String obtenerUsuariopoId(int id) {
        String output = "";
        if (userRepository.existsById(id)) {
            User user = userRepository.findById(id).get();
            output += "ID usuario: " + user.getId() + "\n";
            output += "Nombre de usuario: " + user.getUsername() + "\n";
            output += "Contraseña: " + user.getPassword() + "\n";
            output += "Correo: " + user.getEmail() + "\n";
            return output;
        } else {
            return "No existe un producto con ese id";
        }
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
}
