package Repositorios;

import java.util.ArrayList;

import Negocio.Filmes;

public class RepositorioFilme implements IRepositorioFilme {

	ArrayList<Filmes> filme = new ArrayList<Filmes>();

	public void addFilme(Filmes filme) {
		this.filme.add(filme);
	}

	public void deleteFilme(Filmes filme) {
		this.filme.remove(filme);
	}

	public ArrayList<Filmes> getArrayFilmes() {
		return this.filme;
	}

	public String getAllFilmes() {
		String result = "-------------------"
				+ "\n| Lista de Filmes |\n"
				+ "-------------------\n\n";

		for (Filmes filme : this.filme) {
			result += filme.toString() + "\n";
		}

		return result;
	}

	public String getAllFilmesBySituation(int situacao) {
		String result = "";

		for (Filmes f : filme) {
			if (f.getSituaticao() == situacao) {
				result += "Nome: " + f.getNome() + "\nGênero: " + f.getGenero() + "\nDescrição: " + f.getDescricao()
						+ "\n\n";
			}
		}

		return result;
	}

	public Filmes getFilmeByNome(String nome) {
		Filmes filmeProcurado = null;

		for (Filmes f : filme) {
			if (nome.equals(f.getNome())) {
				filmeProcurado = f;
			}
		}

		return filmeProcurado;
	}

	public Filmes getFilmeById(int id) {
		Filmes filmeProcurado = null;

		for (Filmes f : filme) {
			if (f.getId() == id) {
				filmeProcurado = f;
			}
		}

		return filmeProcurado;
	}

	public Filmes filmeParaComprar(String nome) {
		Filmes filmeComprar = getFilmeByNome(nome);

		if (filmeComprar != null) {
			if (filmeComprar.getSituaticao() == 1) {
				return filmeComprar;
			} else {
				filmeComprar = null;
			}
		}

		return filmeComprar;
	}
}
