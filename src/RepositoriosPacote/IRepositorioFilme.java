package RepositoriosPacote;

// Dados
import DadosPacote.Filmes;

// Libs
import java.util.ArrayList;

public interface IRepositorioFilme {
    public void addFilme(Filmes filme);

    public void deleteFilme(Filmes filme);

    public ArrayList<Filmes> getArrayFilmes();

    public String getAllFilmes();

    public String getAllFilmesBySituation(int situacao);

    public Filmes getFilmeByNome(String nome);

    public Filmes getFilmeById(int id);
}
