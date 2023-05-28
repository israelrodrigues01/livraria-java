package Negocio;

import java.util.ArrayList;

import Repositorios.*;

public class Verificacoes {
	public boolean isEmail(IRepositorioUser usuarios, String email) {

		ArrayList<Usuario> users = usuarios.getArrayUser();

		for (Usuario u : users) {
			if (email.equals(u.getEmail())) {
				return true;
			}
		}
		return false;
	}

	public boolean verificarSenha(IRepositorioUser usuarios, String senha) {
		ArrayList<Usuario> users = usuarios.getArrayUser();

		for (Usuario u : users) {
			if (senha.equals(u.getSenha())) {
				return true;
			}
		}
		return false;
	}

	public boolean verificaNomeFilme(IRepositorioFilme filme, String nome) {
		ArrayList<Filmes> filmes = filme.getArrayFilmes();

		for (Filmes f : filmes) {
			if (nome.equals(f.getNome())) {
				return true;
			}
		}

		return false;
	}
}
