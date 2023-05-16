package Negocio;

public class Filmes {
	private int id;
	private int idComprador;
	private String nome;
	private String genero;
	private String descricao;
	private int situaticao;

	Filmes(int id, String nome, String genero, String descricao, int situacao) {
		this.id = id;
		this.nome = nome;
		this.genero = genero;
		this.descricao = descricao;
		this.situaticao = situacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdComprador() {
		return idComprador;
	}

	public void setIdComprador(int idComprador) {
		this.idComprador = idComprador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getSituaticao() {
		return situaticao;
	}

	public void setSituaticao(int situaticao) {
		this.situaticao = situaticao;
	}

	@Override
	public String toString() {
		return "Filme [id= " + id + ", nome= " + nome + ", genero= " + genero + ", descricao= " + descricao
				+ ", situaticao= " + situaticao + "]";
	}
}
