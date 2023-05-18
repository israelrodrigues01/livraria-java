package Fachada;

import Negocio.*;
import Repositorios.*;

public class Loja {

    private IRepositorioUser usersRepositorio;
    private IRepositorioFilme filmesRepositorio;
    private RepositorioMeusFilmes meusFilmes;
    private Login login = new Login();
    private Verificacoes verificar = new Verificacoes();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private FilmesDAO filmesDAO = new FilmesDAO();

    public Loja() {
        usersRepositorio = new RepositorioUser();
        filmesRepositorio = new RepositorioFilme();
        meusFilmes = new RepositorioMeusFilmes();

        this.cadastroConta("Cicero israel", "teste@gmail.com", "123", 0);
        this.cadastroConta("Admin", "admin@gmail.com", "123", 1);
    }

    // Negócio Login Start
    public void acessarConta(String email, String senha) {
        login.acessar(usersRepositorio, email, senha);
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

    public boolean verificaNomeFilme(String nome) {
        return verificar.verificaNomeFilme(filmesRepositorio, nome);
    }

    // Negócio Filmes Start

    public String getAllFilmes() {
        return filmesRepositorio.getAllFilmes();
    }

    public void addFilme(String name, String gender, String description) {
        filmesDAO.addFilme(name, gender, description, filmesRepositorio);
    }

    public void editMovie(int option, Filmes filme) {
        filmesDAO.opcoesEditarFilmes(option, filme, filmesRepositorio);
    }

    public void removeMovie(Filmes filme) {
        filmesDAO.removeMovie(filme, filmesRepositorio);
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

    // Negócio Usuários Start

    public void cadastroConta(String nome, String email, String senha, int permissao) {
        usuarioDAO.cadastro(usersRepositorio, nome, email, senha, permissao);
    }

    public String getAllUsers() {
        return usersRepositorio.getAllUsers();
    }

    public void editUser(int option) {
        usuarioDAO.opcoesEditarUser(option, getUserLogado(), usersRepositorio);
    }

    public void editUsers(int option, Usuario user) {
        usuarioDAO.opcoesEditarUser(option, user, usersRepositorio);
    }

    public void removeUsers(Usuario user) {
        usuarioDAO.removeUser(user, usersRepositorio);
    }

    public Usuario getUserById(int id) {
        return usersRepositorio.getUserById(id);
    }

    public Usuario getUserByEmail(String email) {
        return usersRepositorio.getUserByEmail(email);
    }

    // Negócio Usuários End
}
