package RepositoriosPacote;

import DadosPacote.Filmes;

import java.util.ArrayList;

public class RepositorioFilme {
	
	ArrayList<Filmes> filme = new ArrayList<Filmes>();

	public void addFilme(Filmes filme) {
		this.filme.add(filme);
	}
	
	public void updateFilme() {
		
	}
	
	public void deleteFilme(int id) {
		Filmes filmeParaExcluir = null;
		for(Filmes f : filme ) {
			if (f.getId() == id) {
				filmeParaExcluir = f;
				break;
			}
		}
		if (filmeParaExcluir != null) {
			filme.remove(filmeParaExcluir);
			
		}else {
			System.out.println("Filme não encontrado");
		}
		
	}
	
	public String getAllFilmes() {
		String result = "";
		
		for(Filmes filme: this.filme) {
			result += filme.toString() + ""
					+ "-----------------------"
					+ "\n\n\n" ;
		}
		
		return "Lista de filmes \n" + result;
	}
	
	public void getFilmeById() {
		
	}
	
}
