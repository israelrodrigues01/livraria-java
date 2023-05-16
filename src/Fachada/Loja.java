package Fachada;

import Negocio.*;
import Repositorios.*;

public class Loja {

    private IRepositorioUser usersRepositorio;
    private IRepositorioFilme filmesRepositorio;
    private RepositorioMeusFilmes meusFilmes;
    private Login login = new Login();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private FilmesDAO filmesDAO = new FilmesDAO();

    public Loja() {
        usersRepositorio = new RepositorioUser();
        filmesRepositorio = new RepositorioFilme();
        meusFilmes = new RepositorioMeusFilmes();
    }

    // Negócio Login Start
    public void acessarConta(String email, String senha) {
        login.acessar(usersRepositorio, email, senha);
    }

    public void cadastroConta(String nome, String email, String senha) {
        usuarioDAO.cadastro(usersRepositorio, nome, email, senha);
    }

    public IRepositorioUser getUsers() {
        return usersRepositorio;
    }

    public Usuario getUserLogado() {
        return login.getUserLogado();
    }

    public void logout() {
        login.logout();
    }

    public boolean isLogado() {
        return login.isLogado();
    }

    // Negócio Login End

    public String getAll() {
        return usersRepositorio.getAllUsers();
    }

    // Negócio Filmes Start

    public String getAllFilmes() {
        return filmesRepositorio.getAllFilmes();
    }

    public String getAllFilmesBySituation(int situation) {
        return filmesRepositorio.getAllFilmesBySituation(situation);
    }

    public Filmes getFilmeByNome(String nome) {
        return filmesRepositorio.getFilmeByNome(nome);
    }

    public Filmes getFilmeById(int id) {
        return filmesRepositorio.getFilmeById(id);
    }

    public Filmes filmeComprar(String nome) {
        return filmesRepositorio.filmeParaComprar(nome);
    }

    public String getAllMyFilmesString(int id) {
        return meusFilmes.getAllFilmes(id);

    }

    public String getAllMyFilmes(int id) {
        return meusFilmes.getAllFilmes(id);
    }

    public void filmeComprado(Filmes filme, int id) {
        meusFilmes.addFilme(filme, id);
        filmesDAO.filmeComprado(filme, filmesRepositorio);
    }
    // Negócio Filmes End
}
