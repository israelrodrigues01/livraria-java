package RepositoriosPacote;

import DadosPacote.Filmes;

import java.util.ArrayList;

public class RepositorioMeusFilmes {
    ArrayList<Filmes> filme = new ArrayList<Filmes>();

    public void addFilme(Filmes filme) {
        this.filme.add(filme);
    }

    public void deleteFilme(Filmes filme) {
        this.filme.remove(filme);
    }

    public String getAllFilmes() {
        String result = "";

        for (Filmes f : filme) {
            result += "Nome: " + f.getNome() + "\nGênero: " + f.getGenero() + "\nDescrição: " + f.getDescricao()
                    + "\n\n";
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
}
