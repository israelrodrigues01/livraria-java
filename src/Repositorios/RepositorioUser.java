package Repositorios;

import java.util.ArrayList;

import Excecoes.UsuarioNaoEncontradoException;
import Negocio.Usuario;

public class RepositorioUser implements IRepositorioUser {

	ArrayList<Usuario> usuario = new ArrayList<Usuario>();

	public void addUser(Usuario usuario) {
		this.usuario.add(usuario);
	}

	public void deleteUser(Usuario usuario) {
		this.usuario.remove(usuario);
	}

	public ArrayList<Usuario> getArrayUser() {
		return this.usuario;
	}

	public String getAllUsers() {
		String resultado = "";

		System.out.println("Usuários:");
		for (Usuario user : this.usuario) {
			resultado += user.toString() + "\n";
		}

		return resultado;
	}

	public Usuario getUserByEmail(String email) throws UsuarioNaoEncontradoException {
		for (Usuario u : usuario) {
			if (u.getEmail().equals(email)) {
				return u;
			}
		}

		throw new UsuarioNaoEncontradoException();
	}

	public Usuario getUserById(int id) throws UsuarioNaoEncontradoException {
		for (Usuario u : usuario) {
			if (u.getId() == id) {
				return u;
			}
		}

		throw new UsuarioNaoEncontradoException();
	}
}
