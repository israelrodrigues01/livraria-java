package Negocio;

import java.util.Scanner;

import Excecoes.UsuarioCadastradoException;
import IU.LimparConsole;
import Repositorios.IRepositorioUser;

public class UsuarioDAO {
    private static int idUser = 0;

    Verificacoes verificar = new Verificacoes();

    Scanner input = new Scanner(System.in);
    LimparConsole console = new LimparConsole();

    public void cadastro(IRepositorioUser usuarios, String nome, String email, String senha, int permissao)
            throws UsuarioCadastradoException {
        Usuario usuario = null;
        if (!verificar.isEmail(usuarios, email)) {
            idUser += 1;
            if (permissao == 0) {
                usuario = new Usuario(idUser, nome, email, senha);
            } else {
                usuario = new Admin(idUser, nome, email, senha);
            }
            usuarios.addUser(usuario);
        } else {
            throw new UsuarioCadastradoException();
        }
    }

    public void removeUser(Usuario user, IRepositorioUser usuarios) {
        usuarios.deleteUser(user);
    }

    public void editarNome(Usuario user) {
        String nome;
        System.out.println("Adicione seu novo nome de usuário: ");

        do {
            nome = input.nextLine();
        } while (nome == "");

        user.setNome(nome);
    }

    public void editarEmail(Usuario user, IRepositorioUser usuarios) {
        int count = 0;
        String email;

        do {
            if (count < 1) {
                System.out.println("Adicione seu novo email de login: ");
            } else {
                System.out.println("\nNão foi possível adicionar com este email, tente usar outro: ");
            }
            do {
                email = input.nextLine();
            } while (email == "");
            count++;
        } while (verificar.isEmail(usuarios, email));

        user.setEmail(email);
    }

    public void editarSenha(Usuario user) {
        String senha;
        String confirmSenha;
        int count = 0;

        do {
            if (count >= 1) {
                console.limpar();
                System.out.println("-------------------------------------------------\n"
                        + "| Senha diferentes, por favor digite novamente! |\n"
                        + "-------------------------------------------------\n\n");
            }

            System.out.println("Digite sua senha: ");
            do {
                senha = input.nextLine();
            } while (senha == "");

            System.out.println("\nConfirme sua senha: ");
            do {
                confirmSenha = input.nextLine();
            } while (confirmSenha == "");

            count++;
        } while (!senha.equals(confirmSenha));

        user.setSenha(senha);
    }

    public void editarUser(Usuario user, IRepositorioUser usuarios) {
        this.editarNome(user);
        System.out.println("\n");
        this.editarEmail(user, usuarios);
        System.out.println("\n");
        this.editarSenha(user);
    }

    public void opcoesEditarUser(int opcao, Usuario user, IRepositorioUser usuarios) {
        switch (opcao) {
            case 1: {
                console.limpar();
                this.editarNome(user);
                System.out.println("----------------"
                        + "\n| Nome editado |\n"
                        + "----------------");
                break;
            }
            case 2: {
                console.limpar();
                this.editarEmail(user, usuarios);
                System.out.println("-----------------"
                        + "\n| Email editado |\n"
                        + "-----------------");
                break;
            }
            case 3: {
                console.limpar();
                this.editarSenha(user);
                System.out.println("-----------------"
                        + "\n| Senha editada |\n"
                        + "-----------------");
                break;
            }
            case 4: {
                console.limpar();
                this.editarUser(user, usuarios);
                System.out.println("-------------------"
                        + "\n| Usuário Editado |\n"
                        + "-------------------");
                break;
            }
            default: {
                System.out.println("Opção invalida");
                break;
            }
        }
    }
}
