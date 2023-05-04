package DadosPacote;

import RepositoriosPacote.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {

	Verificacoes verificar = new Verificacoes();

	Scanner input = new Scanner(System.in);
	LimparConsole console = new LimparConsole();

	private boolean logado = false;

	public void acessar(RepositorioUser usuarios) {
		String email, senha;
		int count = 0;

		System.out.println("\nDigite seu email: ");
		email = input.nextLine();

		if (verificar.isEmail(usuarios, email)) {
			System.out.println("\nDigite sua senha: ");
			senha = input.nextLine();

			while (!(verificar.verificarSenha(usuarios, senha))) {
				if (count < 5) {
					System.out.println("\nPor favor, digite a senha novamente: ");
					senha = input.nextLine();
				} else {
					System.out.println("\nNão foi possivel conectar na sua conta, tente outro momento!");
					break;
				}

				count++;
			}

			if (count < 5) {
				logado = true;
			}

			console.limpar();
		} else {
			console.limpar();
			System.out.println("\nCadastre-se antes de fazer Login.");
		}
	}

	public Usuario cadastro(RepositorioUser usuarios) {
		System.out.println("Digite seu nome: ");
		String nome = input.nextLine();
		String email;
		String senha;
		String confirmSenha;

		int count = 0;

		do {
			if (count < 1) {
				System.out.println("\nDigite seu melhor email: ");
			} else {
				System.out.println("\nNão foi possível acessar com este email, tente usar outro: ");
			}
			email = input.nextLine();
			count++;
		} while (verificar.isEmail(usuarios, email));
		count = 0;

		do {
			if (count >= 1) {
				console.limpar();
				System.out.println("-------------------------------------------------\n"
						+ "| Senha diferentes, por favor digite novamente! |\n"
						+ "-------------------------------------------------\n"
						+ "\nNome informado: " + nome
						+ "\nEmail informado: " + email);
			}

			System.out.println("\nDigite sua senha: ");
			senha = input.nextLine();

			System.out.println("\nConfirme sua senha: ");
			confirmSenha = input.nextLine();

			count++;
		} while (!senha.equals(confirmSenha));

		Usuario usuario = new Usuario(nome, email, senha);

		console.limpar();
		System.out.println("--------------------------------------------------------------------------\n"
				+ "| Cadastro realizado com sucesso, agora faça login para acessar a conta! |\n"
				+ "--------------------------------------------------------------------------\n\n");

		return usuario;
	}

	public boolean isLogado() {
		return this.logado;
	}

}
