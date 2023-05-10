package DadosPacote;

import RepositoriosPacote.RepositorioUser;

import java.util.Scanner;

public class UsuarioDAO {
    private static int idUser = 0;

    Verificacoes verificar = new Verificacoes();

    Scanner input = new Scanner(System.in);
    LimparConsole console = new LimparConsole();

    public Usuario cadastro(RepositorioUser usuarios) {
        String nome;
        String email;
        String senha;
        String confirmSenha;
        int count = 0;

        console.limpar();

        System.out.println("------------"
                + "\n| Cadastro |\n"
                + "------------\n\n"
                + "Digite seu nome: ");
        do {
            nome = input.nextLine();
        } while (nome == "");

        do {
            if (count < 1) {
                System.out.println("\nDigite seu melhor email: ");
            } else {
                System.out.println("\nNão foi possível acessar com este email, tente usar outro: ");
            }
            do {
                email = input.nextLine();
            } while (email == "");
            count++;
        } while (verificar.isEmail(usuarios, email));
        count = 0;

        do {
            if (count >= 1) {
                console.limpar();
                System.out.println("-------------------------------------------------\n"
                        + "| Senha diferentes, por favor digite novamente! |\n"
                        + "-------------------------------------------------\n"
                        + "\nNome informado: " + nome
                        + "\nEmail informado: " + email);
            }

            System.out.println("\nDigite sua senha: ");
            senha = input.nextLine();

            System.out.println("\nConfirme sua senha: ");
            confirmSenha = input.nextLine();

            count++;
        } while (!senha.equals(confirmSenha));

        idUser += 1;
        Usuario usuario = new Usuario(idUser, nome, email, senha);

        console.limpar();
        System.out.println("--------------------------------------------------------------------------"
                + "\n| Cadastro realizado com sucesso, agora faça login para acessar a conta! |\n"
                + "--------------------------------------------------------------------------\n\n");

        return usuario;
    }

    public Usuario addUser(RepositorioUser usuarios) {
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

    public void editarEmail(Usuario user, RepositorioUser usuarios) {
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

    public void editarUser(Usuario user, RepositorioUser usuarios) {
        this.editarNome(user);
        System.out.println("\n");
        this.editarEmail(user, usuarios);
        System.out.println("\n");
        this.editarSenha(user);
    }

    public String opcoesEditarUser(int opcao, Usuario user, RepositorioUser usuarios) {
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
