package DadosPacote;

public class Admin extends Usuario {
	public Admin(int id, String nome, String email, String senha) {
		super(id, nome, email, senha);
		this.setPermissao(1);
	}
}
