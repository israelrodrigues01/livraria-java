package IU;

import Fachada.Loja;

import java.util.Scanner;

public class SistemaTeste {
	public static void main(String[] args) {
		// Fachada
		Loja loja = new Loja();

		// IU (Interface do Usuário)
		IndexIU index = new IndexIU(loja);
		LimparConsole console = new LimparConsole();

		// Libs
		Scanner input = new Scanner(System.in);

		boolean run = true;

		console.limpar();
		do {
			index.login();
			index.viewUser();
		} while (run);

		input.close();
	}
}
