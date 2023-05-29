package IU;

import java.util.Scanner;

import Excecoes.UsuarioCadastradoException;
import Excecoes.UsuarioNaoEncontradoException;
import Fachada.Loja;

public class UserIU {
    private LimparConsole console = new LimparConsole();
    private Menus menu = new Menus();
    private Scanner input = new Scanner(System.in);
    private Loja fachada;
    private boolean sair = false;
    private int number;

    public UserIU(Loja fachada) {
        this.fachada = fachada;
    }

    public void listUsers() {
        console.limpar();
        System.out.println(fachada.getAllUsers());
    }

    public void addUser() {
        String nome;
        String email;
        String senha;
        int permissao;
        int count = 0;

        console.limpar();

        System.out.println("--------------------------"
                + "\n| Adicionar Novo Usuário |\n"
                + "--------------------------\n\n"
                + "Digite o nome: ");
        do {
            nome = input.nextLine();
        } while (nome == "");

        if (count < 1) {
            System.out.println("\nDigite o melhor email: ");
        }
        do {
            email = input.nextLine();
        } while (email == "");

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

        try {
            fachada.cadastroConta(nome, email, senha, permissao);

            console.limpar();
            System.out.println("---------------------------------"
                    + "\n| Usuário inserido com sucesso! |\n"
                    + "---------------------------------\n\n");
        } catch (UsuarioCadastradoException e) {
            console.limpar();
            System.out.println(e.getMessage());
        }
    }

    public void profile() {
        do {
            console.limpar();
            System.out.println("---------------------"
                    + "\n| Perfil do Usuário |\n"
                    + "---------------------\n\n");

            System.out.println(""
                    + "Nome: " + fachada.getUserLogado().getNome()
                    + "\nEmail: " + fachada.getUserLogado().getEmail()
                    + "\nSenha: " + fachada.getUserLogado().getSenha());

            System.out.println("\n1 - Voltar");
            number = input.nextInt();

            if (number == 1) {
                sair = true;
            }
        } while (!sair);
        sair = false;
    }

    public void myMovie() {
        int opcao;

        do {
            console.limpar();
            System.out.println("---------------"
                    + "\n| Meus Filmes |\n"
                    + "---------------\n\n"
                    + fachada.getAllMyFilmes(fachada.getUserLogado().getId())
                    + "\n1 - Voltar");
            opcao = input.nextInt();

            if (opcao == 1)
                sair = true;

        } while (!sair);
        sair = false;
    }

    public void editUserByEmail(String email) {
        int opcao;
        do {
            console.limpar();
            menu.editUserMenu();

            opcao = input.nextInt();
            try {
                if (opcao != 5) {
                    fachada.editUsers(opcao, fachada.getUserByEmail(email));
                } else {
                    sair = true;
                }
                console.limpar();
            } catch (UsuarioNaoEncontradoException e) {
                console.limpar();
                System.out.println(e.getMessage());
                sair = true;
            }
        } while (!sair);
        sair = false;
    }

    public void removeUserByEmail(String email) {
        try {
            console.limpar();
            fachada.removeUsers(fachada.getUserByEmail(email));
        } catch (UsuarioNaoEncontradoException e) {
            console.limpar();
            System.out.println(e.getMessage());
        }
    }

    public void editUserById(int id) {
        int opcao;
        do {
            console.limpar();
            menu.editUserMenu();

            opcao = input.nextInt();
            try {
                if (opcao != 5) {
                    fachada.editUsers(opcao, fachada.getUserById(id));
                } else {
                    sair = true;
                }
                console.limpar();
            } catch (UsuarioNaoEncontradoException e) {
                console.limpar();
                System.out.println(e.getMessage());
                sair = true;
            }
        } while (!sair);
        sair = false;
    }

    public void removeUserById(int id) {
        try {
            console.limpar();
            fachada.removeUsers(fachada.getUserById(id));
        } catch (UsuarioNaoEncontradoException e) {
            console.limpar();
            System.out.println(e.getMessage());
        }
    }

    public void editUsers(int type) {
        int idUser;
        String emailUser;
        String action = type == 1 ? "edit" : "remove";

        do {
            do {
                console.limpar();
                System.out.println("Deseja pesquisar por email ou id?"
                        + "\n1 - Id"
                        + "\n2 - Email");
                number = input.nextInt();

                if (number == 1) {
                    console.limpar();
                    System.out.println("Digite o id do usuário: ");

                    do {
                        idUser = input.nextInt();
                    } while (idUser < 0);

                    if (action == "edit") {
                        this.editUserById(idUser);
                    } else {
                        this.removeUserById(idUser);
                    }

                } else if (number == 2) {
                    console.limpar();
                    System.out.println("Digite o email do usuário: ");
                    do {
                        emailUser = input.nextLine();
                    } while (emailUser == "");

                    if (action == "edit") {
                        this.editUserByEmail(emailUser);
                    } else {
                        this.removeUserByEmail(emailUser);
                    }
                }
            } while (number < 1 || number > 2);

            System.out.println("Deseja tentar novamente ou sair?"
                    + "\n1 - Tentar Novamente"
                    + "\n2 - Sair");
            number = input.nextInt();
            if (number == 2)
                sair = true;

        } while (!sair);
        console.limpar();
        sair = false;
    }
}
