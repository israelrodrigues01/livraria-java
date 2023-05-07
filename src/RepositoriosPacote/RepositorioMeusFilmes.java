package RepositoriosPacote;

import DadosPacote.Filmes;
import DadosPacote.Usuario;

import java.util.ArrayList;

public class RepositorioMeusFilmes {
    ArrayList<Filmes> filme = new ArrayList<Filmes>();

    public void addFilme(Filmes novoFilme, int idComprador) {
        novoFilme.setIdComprador(idComprador);
        this.filme.add(novoFilme);
    }

    public void deleteFilme(Filmes filme) {
        this.filme.remove(filme);
    }

    public String getAllFilmes(int idComprador) {
        String result = "";

        for (Filmes f : filme) {
            if (f.getIdComprador() == idComprador) {
                result += "Nome: " + f.getNome() + "\nGênero: " + f.getGenero() + "\nDescrição: " + f.getDescricao()
                        + "\n\n";
            }
        }

        return result;
    }

    public Filmes getFilmeByNome(String nome) {
        Filmes filmeProcurado = null;

        for (Filmes f : filme) {
            if (nome.equals(f.getNome())) {
                filmeProcurado = f;
            }
        }

        return filmeProcurado;
    }

    public Filmes getFilmeById(int idComprador) {
        Filmes filmeProcurado = null;

        for (Filmes f : filme) {
            if (f.getId() == idComprador) {
                filmeProcurado = f;
            }
        }

        return filmeProcurado;
    }
}
