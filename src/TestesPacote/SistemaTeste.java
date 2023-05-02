package TestesPacote;

import DadosPacote.*;
import RepositoriosPacote.*;

import java.util.Scanner;

public class SistemaTeste {
	public static void main(String[] args) {

		// Classes
		LimparConsole console = new LimparConsole();
		Menus menu = new Menus();
		Login login = new Login();

		// Repositorios
		RepositorioUser usuario = new RepositorioUser();

		// Libs
		Scanner input = new Scanner(System.in);

		boolean run = true;

		// Index

		do {
			System.out.println("Bem-vindo(a) ao Prime Filmes :)");

			Usuario user = new Usuario("Cicero israel", "teste@gmail.com", "123");
			usuario.addUser(user);

			do {
				menu.loginMenu();
				int number = input.nextInt();

				switch (number) {
				case 1: {
					login.acessar(usuario);
					break;
				}
				case 2: {
					usuario.addUser(login.cadastro(usuario));
					break;
				}
				case 3: {
					run = false;
					break;
				}
				default:
					System.out.println("Opção invalida");
					break;
				}

			} while (!login.isLogado() && run);

			if (login.isLogado()) {
				System.out.println("Fez o login!!!");
			}

			// Finish System
			if (!run) {
				System.out.println("\n\nObrigado por usar nosso sistema, volte sempre!");
			}

		} while (run);
	}
}
