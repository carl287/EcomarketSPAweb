package com.example.EcomarketSPAweb.Services;

import com.example.EcomarketSPAweb.Model.AdminUser;
import com.example.EcomarketSPAweb.Model.User;
import com.example.EcomarketSPAweb.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminUserService {

    @Autowired
    private UserRepository userRepository;

    // Listar todos los usuarios
    public List<User> obtenerTodosLosUsuarios() {
        return userRepository.findAll();
    }

    // Agregar usuario
    public User agregarUsuario(User nuevoUsuario) {
        nuevoUsuario.setActive(true);
        return userRepository.save(nuevoUsuario);
    }

    // Modificar usuario
    public User modificarUsuario(int id, User datosActualizados) {
        Optional<User> usuario = userRepository.findById(id);
        if (usuario.isPresent()) {
            User existente = usuario.get();
            existente.setUsername(datosActualizados.getUsername());
            existente.setEmail(datosActualizados.getEmail());
            existente.setPassword(datosActualizados.getPassword());
            return userRepository.save(existente);
        } else {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
    }

    // Desactivar usuario (soft delete)
    public void desactivarUsuario(int id) {
        Optional<User> usuario = userRepository.findById(id);
        if (usuario.isPresent()) {
            User existente = usuario.get();
            existente.setActive(false);
            userRepository.save(existente);
        } else {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
    }
    // Se elimina el usuario por id
    public void eliminarUsuarioPorId(int id) {
        Optional<User> usuario = userRepository.findById(id);
        if (usuario.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
    }
}
