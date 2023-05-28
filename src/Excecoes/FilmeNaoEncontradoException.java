package Excecoes;

public class FilmeNaoEncontradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FilmeNaoEncontradoException() {
		super("------------------------"
				+ "\n| Filme não encontrado |\n"
				+ "------------------------\n\n");
	}
}
