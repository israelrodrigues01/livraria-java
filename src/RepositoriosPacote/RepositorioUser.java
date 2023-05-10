package RepositoriosPacote;

import DadosPacote.Usuario;

import java.util.ArrayList;

public class RepositorioUser {

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

	public Usuario getUserByEmail(String email) {
		Usuario user = null;

		for (Usuario u : usuario) {
			if (u.getEmail().equals(email)) {
				user = u;
			}
		}

		return user;
	}

	public Usuario getUserById(int id) {
		Usuario user = null;

		for (Usuario u : usuario) {
			if (u.getId() == id) {
				user = u;
			}
		}

		return user;
	}
}
