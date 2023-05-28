package Excecoes;

public class FilmeCadastradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FilmeCadastradoException() {
		super("------------------------------------------------------------------"
				+ "\n| Não foi possivel fazer o cadastro, tente novamente mais tarde! |\n"
				+ "------------------------------------------------------------------\n\n");
	}

}
