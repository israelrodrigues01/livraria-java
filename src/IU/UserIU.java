package IU;

import java.util.Scanner;

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

        fachada.cadastroConta(nome, email, senha, permissao);

        console.limpar();
        System.out.println("---------------------------------"
                + "\n| Usuário inserido com sucesso! |\n"
                + "---------------------------------\n\n");
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

    public void editProfile() {
        do {
            console.limpar();
            menu.editUserMenu();

            number = input.nextInt();
            if (number == 5) {
                sair = true;
            } else {
                fachada.editUser(number);
            }

        } while (!sair);
        console.limpar();
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
            if (opcao != 5) {
                fachada.editUsers(opcao, fachada.getUserByEmail(email));
            } else {
                sair = true;
            }

        } while (!sair);
        console.limpar();
        sair = false;
    }

    public void removeUserByEmail(String email) {
        fachada.removeUsers(fachada.getUserByEmail(email));
    }

    public void editUserById(int id) {
        int opcao;
        do {
            console.limpar();
            menu.editUserMenu();

            opcao = input.nextInt();
            if (opcao != 5) {
                fachada.editUsers(opcao, fachada.getUserById(id));
            } else {
                sair = true;
            }
        } while (!sair);
        console.limpar();
        sair = false;
    }

    public void removeUserById(int id) {
        fachada.removeUsers(fachada.getUserById(id));
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

                    if (fachada.getUserById(idUser) != null) {
                        if (action == "edit") {
                            this.editUserById(idUser);
                        } else {
                            this.removeUserById(idUser);
                        }
                    } else {
                        console.limpar();
                        System.out.println("--------------------------"
                                + "\n| Usuário não encontrado |\n"
                                + "--------------------------\n\n");
                    }

                } else if (number == 2) {
                    console.limpar();
                    System.out.println("Digite o email do usuário: ");
                    do {
                        emailUser = input.nextLine();
                    } while (emailUser == "");

                    if (fachada.getUserByEmail(emailUser) != null) {
                        if (action == "edit") {
                            this.editUserByEmail(emailUser);
                        } else {
                            this.removeUserByEmail(emailUser);
                        }
                    } else {
                        console.limpar();
                        System.out.println("--------------------------"
                                + "\n| Usuário não encontrado |\n"
                                + "--------------------------\n\n");
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
