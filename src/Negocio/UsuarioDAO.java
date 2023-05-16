package Negocio;

import java.util.Scanner;

import IU.LimparConsole;
import Repositorios.IRepositorioUser;

public class UsuarioDAO {
    private static int idUser = 0;

    Verificacoes verificar = new Verificacoes();

    Scanner input = new Scanner(System.in);
    LimparConsole console = new LimparConsole();

    public void cadastro(IRepositorioUser usuarios, String nome, String email, String senha) {
        if (!verificar.isEmail(usuarios, email)) {
            idUser += 1;
            Usuario usuario = new Usuario(idUser, nome, email, senha);
            usuarios.addUser(usuario);
        } else {
            // Email já existe;
        }
    }

    public Usuario addUser(IRepositorioUser usuarios) {
        String nome;
        String email;
        String senha;
        int permissao;
        int count = 0;

        Usuario usuario = null;

        console.limpar();

        System.out.println("--------------------------"
                + "\n| Adicionar Novo Usuário |\n"
                + "--------------------------\n\n"
                + "Digite o nome: ");
        do {
            nome = input.nextLine();
        } while (nome == "");

        do {
            if (count < 1) {
                System.out.println("\nDigite o melhor email: ");
            } else {
                System.out.println("\nNão foi possível adicionar com este email, tente usar outro: ");
            }
            do {
                email = input.nextLine();
            } while (email == "");
            count++;
        } while (verificar.isEmail(usuarios, email));

        System.out.println("\nDigite uma senha: ");
        senha = input.nextLine();

        count = 0;

        do {
            if (count < 1) {
                System.out.print("\nPermissão do usuário:");
            } else {
                System.out.print("\nPor favor, Permissão do usuário só com os valores:");
            }
            System.out.println("\n0 - Usuário normal"
                    + "\n1 - Admin");

            permissao = input.nextInt();

            count++;
        } while (permissao < 0 || permissao > 1);

        idUser += 1;

        if (permissao == 0) {
            usuario = new Usuario(idUser, nome, email, senha);
        } else {
            usuario = new Admin(idUser, nome, email, senha);
        }

        console.limpar();
        System.out.println("---------------------------------"
                + "\n| Usuário inserido com sucesso! |\n"
                + "---------------------------------\n\n");

        return usuario;
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

    public String opcoesEditarUser(int opcao, Usuario user, IRepositorioUser usuarios) {
        String mensagem = "";
        switch (opcao) {
            case 1: {
                console.limpar();
                this.editarNome(user);
                mensagem = "----------------"
                        + "\n| Nome editado |\n"
                        + "----------------";
                break;
            }
            case 2: {
                console.limpar();
                this.editarEmail(user, usuarios);
                mensagem = "-----------------"
                        + "\n| Email editado |\n"
                        + "-----------------";
                break;
            }
            case 3: {
                console.limpar();
                this.editarSenha(user);
                mensagem = "-----------------"
                        + "\n| Senha editada |\n"
                        + "-----------------";
                break;
            }
            case 4: {
                console.limpar();
                this.editarUser(user, usuarios);
                mensagem = "-------------------"
                        + "\n| Usuário Editado |\n"
                        + "-------------------";
                break;
            }
            case 5: {
                mensagem = "sair";
                console.limpar();
                break;
            }
            default: {
                System.out.println("Opção invalida");
                break;
            }
        }

        return mensagem;
    }
}
