package DadosPacote;

import java.util.Scanner;

public class Login {

	Scanner input = new Scanner(System.in);
	LimparConsole console = new LimparConsole();

	private boolean logado = false;

	public void acessar() {
		System.out.println("acessar!");
		console.clear();

		this.logado = true;
	}

	public void cadastro() {
		System.out.println("Digite seu nome: ");
		String nome = input.nextLine();

		System.out.println("Digite seu melhor email: ");
		String email = input.nextLine();

		System.out.println("Digite sua senha: ");
		String senha = input.nextLine();

		System.out.println("Confirme sua senha: ");
		String confirmSenha = input.nextLine();

		while (!senha.equals(confirmSenha)) {
			System.out.println("\n\nSenhas diferentes, tente novamente:\n\n" + "Nome digitado: " + nome
					+ "\nEmail digitado: " + email+"\n\n");

			System.out.println("Digite sua senha: ");
			senha = input.nextLine();

			System.out.println("Confirme sua senha: ");
			confirmSenha = input.nextLine();
		}

		Usuario usuario = new Usuario(nome, email, senha);
		

		console.clear();
		// this.acessar();
	}

	public boolean isLogado() {
		return this.logado;
	}

}
