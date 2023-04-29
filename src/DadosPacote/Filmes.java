package DadosPacote;

public class Filmes {
	private int id;
	private String nome;
	private String genero;
	private String descricao;
	private int quantidade;
	private int situaticao;

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

	@Override
	public String toString() {
		return "Filmes [id=" + id + ", nome=" + nome + ", genero=" + genero + ", descricao=" + descricao
				+ ", quantidade=" + quantidade + ", situaticao=" + situaticao + "]";
	}
}
