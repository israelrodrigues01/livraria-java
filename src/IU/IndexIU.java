package IU;

import java.util.Scanner;

import Fachada.Loja;

public class IndexIU {
    private LoginIU loginIu;
    private FilmeIU filmeIU;
    private UserIU userIU;
    private Loja fachada;
    private Menus menu = new Menus();
    private LimparConsole console = new LimparConsole();
    private Scanner input = new Scanner(System.in);
    private int number;
    private boolean sair = false;

    IndexIU(Loja fachada) {
        loginIu = new LoginIU(fachada);
        filmeIU = new FilmeIU(fachada);
        userIU = new UserIU(fachada);
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

    public void viewUser() {
        if (fachada.isLogado()) {
            if (fachada.getUserLogado().getPermissao() == 0) {
                this.user();
            } else if (fachada.getUserLogado().getPermissao() == 1) {
                this.admin();
            }
        }
    }

    public void user() {
        do {
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
                                filmeIU.availableMovie();
                                break;
                            }
                            case 2: {
                                userIU.myMovie();
                                break;
                            }
                            case 3: {
                                filmeIU.buyMovie();
                                break;
                            }
                            case 4: {
                                sair = true;
                                break;
                            }
                            default: {
                                System.out.println("Opção inválida!");
                                break;
                            }
                        }
                    } while (!sair);
                    sair = false;
                    break;
                }
                case 2: {
                    userIU.profile();
                    break;
                }
                case 3: {
                    userIU.editProfile();
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

    public void admin() {
        do {
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
                                filmeIU.availableMovie();
                                break;
                            }
                            case 2: {
                                userIU.myMovie();
                                break;
                            }
                            case 3: {
                                filmeIU.buyMovie();
                                break;
                            }
                            case 4: {
                                sair = true;
                                break;
                            }
                            default: {
                                System.out.println("Opção inválida!");
                                break;
                            }
                        }
                    } while (!sair);
                    sair = false;
                    break;
                }
                case 2: {
                    userIU.profile();
                    break;
                }
                case 3: {
                    userIU.editProfile();
                    break;
                }
                case 4: {
                    boolean sair = false;
                    String mensagem = "";
                    do {
                        console.limpar();

                        if (mensagem != "") {
                            System.out.println(mensagem + "\n\n");
                        }

                        menu.crudUser();
                        number = input.nextInt();
                        switch (number) {
                            case 1: {
                                do {
                                    console.limpar();
                                    userIU.listUsers();

                                    System.out.println("\n1 - Voltar");
                                    number = input.nextInt();

                                    if (number == 1) {
                                        sair = true;
                                    }
                                } while (!sair);
                                sair = false;
                                break;
                            }
                            case 2: {
                                console.limpar();
                                userIU.addUser();
                                break;
                            }
                            case 3: {
                                userIU.editUsers(1);
                                break;
                            }
                            case 4: {
                                userIU.editUsers(0);
                                break;
                            }
                            case 5: {
                                sair = true;
                                console.limpar();
                                break;
                            }
                            default: {
                                System.out.println("Opção invalida");
                                break;
                            }
                        }
                    } while (!sair);
                    break;
                }
                case 5: {
                    String mensagem = "";
                    do {
                        console.limpar();

                        if (mensagem != "") {
                            System.out.println(mensagem + "\n\n");
                        }

                        menu.crudFilme();

                        number = input.nextInt();

                        switch (number) {
                            case 1: {
                                filmeIU.listMovies();
                                break;
                            }
                            case 2: {
                                console.limpar();
                                filmeIU.addMovie();
                                break;
                            }
                            case 3: {
                                console.limpar();
                                filmeIU.editMovie(1);
                                break;
                            }
                            case 4: {
                                console.limpar();
                                filmeIU.editMovie(0);
                                break;
                            }
                            case 5: {
                                sair = true;
                                console.limpar();
                                break;
                            }
                            default: {
                                System.out.println("Opção invalida");
                                break;
                            }
                        }
                    } while (!sair);
                    sair = false;
                    break;
                }
                case 6: {
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
