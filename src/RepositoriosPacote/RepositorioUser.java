package RepositoriosPacote;

import DadosPacote.Usuario;

import java.util.ArrayList;

public class RepositorioUser {

	ArrayList<Usuario> usuario = new ArrayList<Usuario>();

	public void addUser(Usuario usuario) {
		this.usuario.add(usuario);
	}

	public void updateUser() {

	}

	public void deleteUser() {

	}
	
	public ArrayList<Usuario> getArrayUser(){
		return this.usuario;
	}

	public String getAllUsers() {
		String resultado = "";

		System.out.println("Usuários:");
		for (Usuario user : this.usuario) {
			resultado += "Nome: " + user.getNome() + "\nEmail: " + user.getEmail() + "\n------------------------";
		}

		return resultado;
	}

	public void getUserById() {
		
	}

}
