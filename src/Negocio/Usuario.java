package Negocio;

public class Usuario {

	private int id;
	private String nome;
	private String email;
	private String senha;
	private int permissao;

	public Usuario(int id, String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getPermissao() {
		return permissao;
	}

	public void setPermissao(int permissao) {
		this.permissao = permissao;
	}

	@Override
	public String toString() {
		return "Usuario [id= " + id + ", nome= " + nome + ", email= " + email + ", senha= " + senha + ", permissao= "
				+ permissao + "]";
	}
}