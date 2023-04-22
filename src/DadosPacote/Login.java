package DadosPacote;

import DadosPacote.LimparConsole;

import java.util.Scanner;

public class Login {
	
	Scanner input = new Scanner(System.in);
	LimparConsole console = new LimparConsole();
	
	private boolean logado = false;
	
	public void acessar() {
		System.out.println("acessar!");
		
		this.logado = true;
	}
	
	public void cadastro() {	
		System.out.println("Cadastro sucedido! Agora pode fazer login na sua conta:");
		console.clear();
		// this.acessar();
	}
	
	public boolean isLogado() {
		return this.logado;
	}
	
}
