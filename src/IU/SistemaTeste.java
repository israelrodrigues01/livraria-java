package IU;

import Fachada.Loja;

import java.util.Scanner;

public class SistemaTeste {
	public static void main(String[] args) {
		// Fachada
		Loja loja = new Loja();

		// IU (Interface do Usuário)
		IndexIU index = new IndexIU(loja);

		// Libs
		Scanner input = new Scanner(System.in);

		boolean run = true;

		do {
			index.login();
			index.viewUser();
		} while (run);

		input.close();
	}
}
