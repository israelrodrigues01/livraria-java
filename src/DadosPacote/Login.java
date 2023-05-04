package DadosPacote;

import DadosPacote.UsuarioDAO;
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
