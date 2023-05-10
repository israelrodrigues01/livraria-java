package RepositoriosPacote;

import DadosPacote.Filmes;

public class RepositorioMeusFilmes extends RepositorioFilme {

    public void addFilme(Filmes novoFilme, int idComprador) {
        novoFilme.setIdComprador(idComprador);
        super.addFilme(novoFilme);
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
}
