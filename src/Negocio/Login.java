package Negocio;

import Excecoes.UsuarioNaoEncontradoException;
import Repositorios.*;

public class Login {

	private boolean logado = false;
	private Usuario userLogado = null;
	private Verificacoes verificar = new Verificacoes();

	public void acessar(IRepositorioUser usuarios, String email, String senha) throws UsuarioNaoEncontradoException {
		if (verificar.isEmail(usuarios, email)) {
			if (verificar.verificarSenha(usuarios, senha)) {
				this.logado = true;
				this.setUserLogado(usuarios.getUserByEmail(email));
			}
		}
	}

	public Usuario getUserLogado() {
		return userLogado;
	}

	public void setUserLogado(Usuario user) {
		this.userLogado = user;
	}

	public boolean isLogado() {
		return this.logado;
	}

	public void logout() {
		this.logado = false;
	}
}
