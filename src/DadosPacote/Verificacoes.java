package DadosPacote;

import java.util.ArrayList;

import RepositoriosPacote.*;

public class Verificacoes {
	public boolean isEmail(RepositorioUser usuarios, String email) {

		ArrayList<Usuario> users = usuarios.getArrayUser();

		for (Usuario u : users) {
			if (email.equals(u.getEmail())) {
				return true;
			}
		}
		return false;
	}

	public boolean verificarSenha(RepositorioUser usuarios, String senha) {
		ArrayList<Usuario> users = usuarios.getArrayUser();

		for (Usuario u : users) {
			if (senha.equals(u.getSenha())) {
				return true;
			}
		}
		return false;
	}

	public boolean verificaNomeFilme(RepositorioFilme filme, String nome) {
		ArrayList<Filmes> filmes = filme.getArrayFilmes();

		for (Filmes f : filmes) {
			if (nome.equals(f.getNome())) {
				return true;
			}
		}

		return false;
	}
}
