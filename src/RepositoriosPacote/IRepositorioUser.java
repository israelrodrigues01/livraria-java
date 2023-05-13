package RepositoriosPacote;

// Dados
import DadosPacote.Usuario;

// Libs
import java.util.ArrayList;

public interface IRepositorioUser {

    public void addUser(Usuario usuario);

    public void deleteUser(Usuario usuario);

    public ArrayList<Usuario> getArrayUser();

    public String getAllUsers();

    public Usuario getUserByEmail(String email);

    public Usuario getUserById(int id);

}
