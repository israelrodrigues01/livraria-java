package Excecoes;

public class UsuarioCadastradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioCadastradoException() {
		super("------------------------------------------------------------------"
				+ "\n| Não foi possivel fazer o cadastro, tente novamente mais tarde! |\n"
				+ "------------------------------------------------------------------\n\n");
	}

}
