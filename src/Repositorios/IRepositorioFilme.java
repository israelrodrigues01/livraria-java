package Repositorios;

// Libs
import java.util.ArrayList;

import Excecoes.FilmeNaoEncontradoException;
import Negocio.Filmes;

public interface IRepositorioFilme {
    public void addFilme(Filmes filme);

    public void deleteFilme(Filmes filme);

    public ArrayList<Filmes> getArrayFilmes();

    public String getAllFilmes();

    public String getAllFilmesBySituation(int situacao);

    public Filmes getFilmeByNome(String nome) throws FilmeNaoEncontradoException;

    public Filmes getFilmeById(int id) throws FilmeNaoEncontradoException;

    public Filmes filmeParaComprar(String nome) throws FilmeNaoEncontradoException;
}
