package TestesPacote;

import DadosPacote.*;
import RepositoriosPacote.*;

public class SistemaTeste {
	public static void main(String[] args) {

		LoginTeste login = new LoginTeste();
		RepositorioUser usuario = new RepositorioUser();
		
//		login.logar();
		
		usuario.getAllUsers();
		
		

	}
}
