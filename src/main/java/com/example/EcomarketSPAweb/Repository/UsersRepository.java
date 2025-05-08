package com.example.EcomarketSPAweb.Repository;

import com.example.EcomarketSPAweb.Model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersRepository {
    //arreglo de usuarios
    //arraylist
    private List<User> users = new ArrayList<User>();

    public UsersRepository(){

    }

    //CRUD

    public String addUser(User user){
        users.add(user);
        return "Agregado con exito";
    }

    public String getUsers(){
        String output="";

        for(User u:users){
            output+= "Nombre Ususario: "+ u.getUsername()+"\n";
            output+= "Contraseña: "+ u.getPassword()+"\n";
            output+= "Correo Usuario: "+ u.getEmail()+"\n";
        }

        if (output.length()>0){
            return output;
        }else{
            return "No se encontraron usuarios";
        }
    }

    public String getUser(int id){

        for (User temp : users) {
            if (temp.getId() == id) {
                return temp.toString();
            }
        }
        return "No existe un usuario con ese id";
    }

    public String removeUser(int id){
        for (User temp : users) {
            if (temp.getId() == id) {
                users.remove(temp);
                return "Se ha eliminado el usuario con id: " + id;
            }
        }
        return "No existe un usuario con ese id";
    }

    public String updateUser(int id ,User user){
        int index = 0;
        for (User temp : users) {
            if (temp.getId() == id) {
                index = users.indexOf(temp);
                break;
            }
        }
        if (index != -1) {
            users.set(index, user);
            return "Se ha actualizado el usuario con id: " + id;

        } else {
            return "No existe un usuario con ese id";
        }
    }
}
