package IU;

import java.util.Scanner;

import Fachada.Loja;

public class IndexIU {
    private LoginIU loginIu;
    private FilmeIU filmeIU;
    private Loja fachada;
    private Menus menu = new Menus();
    private LimparConsole console = new LimparConsole();
    private Scanner input = new Scanner(System.in);
    private int number;

    IndexIU(Loja fachada) {
        loginIu = new LoginIU(fachada);
        filmeIU = new FilmeIU(fachada);
        this.fachada = fachada;
    }

    public void login() {
        do {
            console.limpar();
            System.out.println("-----------------------------------"
                    + "\n| Bem-vindo(a) ao Prime Filmes :) |\n"
                    + "-----------------------------------");

            menu.loginMenu();
            number = input.nextInt();

            switch (number) {
                case 1: {
                    loginIu.acessar();
                    break;
                }
                case 2: {
                    loginIu.cadastro();
                    break;
                }
                case 3: {
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        } while (!fachada.isLogado());
    }

    public void user() {
        do {
            boolean sairLoja = false;

            console.limpar();
            menu.userMenu(fachada.getUserLogado().getPermissao());
            number = input.nextInt();

            switch (number) {
                case 1: {
                    do {
                        console.limpar();
                        menu.lojaMenu();
                        int opcaoLoja = input.nextInt();

                        switch (opcaoLoja) {
                            case 1: {
                                int opcao;
                                boolean sairListaFilmes = false;
                                do {
                                    console.limpar();
                                    System.out.println("----------------------"
                                            + "\n| Filmes Disponíveis |\n"
                                            + "----------------------\n\n"
                                            + fachada.getAllFilmesBySituation(1)
                                            + "\n1 - Voltar");

                                    opcao = input.nextInt();

                                    if (opcao == 1)
                                        sairListaFilmes = true;

                                } while (!sairListaFilmes);

                                break;
                            }
                            case 2: {
                                int opcao;
                                boolean sairMeusFilmes = false;
                                do {
                                    console.limpar();
                                    System.out.println("---------------"
                                            + "\n| Meus Filmes |\n"
                                            + "---------------\n\n"
                                            + fachada.getAllMyFilmes(fachada.getUserLogado().getId())
                                            + "\n1 - Voltar");
                                    opcao = input.nextInt();

                                    if (opcao == 1)
                                        sairMeusFilmes = true;

                                } while (!sairMeusFilmes);
                                break;
                            }
                            case 3: {
                                filmeIU.compraFilme();
                                break;
                            }
                            case 4: {
                                sairLoja = true;
                                break;
                            }
                            default: {
                                System.out.println("Opção inválida!");
                                break;
                            }
                        }
                    } while (!sairLoja);
                    break;
                }
                case 2: {
                    boolean sairPerfil = false;
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
                            sairPerfil = true;
                        }
                    } while (!sairPerfil);
                    break;
                }
                case 3: {
                    boolean sair = false;
                    String mensagem = "";
                    do {
                        console.limpar();

                        if (mensagem != "") {
                            System.out.println(mensagem + "\n\n");
                        }

                        menu.editUserMenu();

                        number = input.nextInt();

                        // mensagem = usuarioDAO.opcoesEditarUser(number, userLogado, usuario);

                        if (mensagem == "sair")
                            sair = true;

                    } while (!sair);

                    break;
                }
                case 4: {
                    fachada.logout();
                    console.limpar();
                    break;
                }
                default: {
                    System.out.println("Opção invalida");
                    break;
                }
            }

        } while (fachada.isLogado());
    }
}
