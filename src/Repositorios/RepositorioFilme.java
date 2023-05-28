package Repositorios;

import java.util.ArrayList;

import Excecoes.FilmeNaoEncontradoException;
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
		String result = "";

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

	public Filmes getFilmeByNome(String nome) throws FilmeNaoEncontradoException {

		for (Filmes f : filme) {
			if (nome.equals(f.getNome())) {
				return f;
			}
		}

		throw new FilmeNaoEncontradoException();
	}

	public Filmes getFilmeById(int id) throws FilmeNaoEncontradoException {
		for (Filmes f : filme) {
			if (f.getId() == id) {
				return f;
			}
		}

		throw new FilmeNaoEncontradoException();
	}

	public Filmes filmeParaComprar(String nome) throws FilmeNaoEncontradoException{
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
