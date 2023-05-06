package DadosPacote;

import RepositoriosPacote.*;

import java.util.Scanner;

public class Login {

	Verificacoes verificar = new Verificacoes();
	UsuarioDAO usuarioDao = new UsuarioDAO();

	Scanner input = new Scanner(System.in);
	LimparConsole console = new LimparConsole();

	private boolean logado = false;

	public Usuario acessar(RepositorioUser usuarios) {
		String email, senha;
		int count = 0;

		console.limpar();

		System.out.println("---------"
				+ "\n| Login |\n"
				+ "---------\n\n"
				+ "\nDigite seu email: ");
		do {
			email = input.nextLine();
		} while (email == "");

		if (verificar.isEmail(usuarios, email)) {
			System.out.println("\nDigite sua senha: ");
			do {
				senha = input.nextLine();
			} while (senha == "");

			while (!(verificar.verificarSenha(usuarios, senha))) {
				if (count < 5) {
					console.limpar();
					System.out.println("----------------------------------------"
							+ "\n| Por favor, digite a senha novamente: |\n"
							+ "----------------------------------------\n\n");
					senha = input.nextLine();
				} else {
					console.limpar();
					System.out.println("----------------------------------------------------------------"
							+ "\n| Não foi possivel conectar na sua conta, tente outro momento! |\n"
							+ "----------------------------------------------------------------\n\n");
					break;
				}

				count++;
			}

			if (count < 5) {
				logado = true;
			}

		} else {
			console.limpar();
			System.out.println("------------------------------------"
					+ "\n| Cadastre-se antes de fazer Login |\n"
					+ "------------------------------------\n\n");
		}

		Usuario user = usuarios.getUserByEmail(email);

		return user;
	}

	public Usuario cadastro(RepositorioUser usuarios) {
		return usuarioDao.cadastro(usuarios);
	}

	public boolean isLogado() {
		return this.logado;
	}

	public void logout() {
		this.logado = false;
	}

}
