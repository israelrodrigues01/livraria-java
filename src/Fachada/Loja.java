package Fachada;

import Negocio.*;
import Excecoes.*;
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

        try {

            this.cadastroConta("Cicero israel", "teste@gmail.com", "123", 0);
            this.cadastroConta("Admin", "admin@gmail.com", "123", 1);
        } catch (UsuarioCadastradoException e) {
            e.getMessage();
        }
    }

    // Negócio Login Start
    public void acessarConta(String email, String senha) throws UsuarioNaoEncontradoException {
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

    // Negócio Verificar Start

    public boolean verificaNomeFilme(String name) {
        return verificar.verificaNomeFilme(filmesRepositorio, name);
    }

    public boolean isEmail(String name) {
        return verificar.isEmail(usersRepositorio, name);
    }

    public boolean verificarSenha(String senha) {
        return verificar.verificarSenha(usersRepositorio, senha);
    }

    // Negócio Verificar End

    // Negócio Filmes Start

    public String getAllFilmes() {
        return filmesRepositorio.getAllFilmes();
    }

    public void addMovie(String name, String gender, String description) throws FilmeCadastradoException {
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

    public Filmes getFilmeByNome(String nome) throws FilmeNaoEncontradoException {
        return filmesRepositorio.getFilmeByNome(nome);
    }

    public Filmes getFilmeById(int id) throws FilmeNaoEncontradoException {
        return filmesRepositorio.getFilmeById(id);
    }

    public Filmes filmeComprar(String nome) throws FilmeNaoEncontradoException {
        return filmesRepositorio.filmeParaComprar(nome);
    }

    public String getAllMyFilmesString(int id) {
        return meusFilmes.getAllFilmes(id);

    }

    public String getAllMyFilmes(int id) {
        return meusFilmes.getAllFilmes(id);
    }

    public Filmes getMyFilmeById(int id) throws FilmeNaoEncontradoException {
        return meusFilmes.getFilmeById(id);
    }

    public boolean buyMovie(String name) throws FilmeNaoEncontradoException {
        filmesDAO.buyMovie(name, this.getUserLogado().getId(), filmesRepositorio, meusFilmes);
        return true;
    }

    public void filmeComprado(Filmes filme, int id) {
        meusFilmes.addFilme(filme, id);
        filmesDAO.filmeComprado(filme, filmesRepositorio);
    }
    // Negócio Filmes End

    // Negócio Usuários Start

    public void cadastroConta(String nome, String email, String senha, int permissao)
            throws UsuarioCadastradoException {
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

    public Usuario getUserById(int id) throws UsuarioNaoEncontradoException {
        return usersRepositorio.getUserById(id);
    }

    public Usuario getUserByEmail(String email) throws UsuarioNaoEncontradoException {
        return usersRepositorio.getUserByEmail(email);
    }

    // Negócio Usuários End
}
