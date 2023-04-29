package TestesPacote;

import DadosPacote.*;
import RepositoriosPacote.*;

public class TesteSistema {

	public static void main(String[] args) {
		
		Filmes filme = new Filmes();
		Filmes filme2 = new Filmes();
		
		RepositorioFilme dbFilme = new RepositorioFilme();
		
		dbFilme.addFilme(filme);
		dbFilme.addFilme(filme2);
		
		System.out.println(dbFilme.getAllFilmes());
		
	}
	
}
