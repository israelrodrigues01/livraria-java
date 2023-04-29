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
	
	public void deleteFilme() {
		
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
