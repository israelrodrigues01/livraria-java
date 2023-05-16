package Repositorios;

// Libs
import java.util.ArrayList;

import Negocio.Usuario;

public interface IRepositorioUser {

    public void addUser(Usuario usuario);

    public void deleteUser(Usuario usuario);

    public ArrayList<Usuario> getArrayUser();

    public String getAllUsers();

    public Usuario getUserByEmail(String email);

    public Usuario getUserById(int id);

}
