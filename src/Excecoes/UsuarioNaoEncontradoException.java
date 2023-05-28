package Excecoes;

public class UsuarioNaoEncontradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioNaoEncontradoException() {
		super("--------------------------"
				+ "\n| Usuário não encontrado |\n"
				+ "--------------------------\n\n");
	}
}
