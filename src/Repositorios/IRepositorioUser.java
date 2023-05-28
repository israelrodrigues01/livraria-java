package Repositorios;

// Libs
import java.util.ArrayList;

import Excecoes.UsuarioNaoEncontradoException;
import Negocio.Usuario;

public interface IRepositorioUser {

    public void addUser(Usuario usuario);

    public void deleteUser(Usuario usuario);

    public ArrayList<Usuario> getArrayUser();

    public String getAllUsers();

    public Usuario getUserByEmail(String email) throws UsuarioNaoEncontradoException;

    public Usuario getUserById(int id) throws UsuarioNaoEncontradoException;

}
