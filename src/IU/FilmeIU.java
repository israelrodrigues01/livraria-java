package IU;

import java.util.Scanner;

import Fachada.Loja;

public class FilmeIU {
    private Menus menu = new Menus();
    private LimparConsole console = new LimparConsole();
    private Scanner input = new Scanner(System.in);
    private Loja fachada;
    private boolean sair = false;
    private int number;

    public FilmeIU(Loja fachada) {
        this.fachada = fachada;
    }

    public void listMovies() {
        do {
            console.limpar();
            System.out.println(fachada.getAllFilmes());

            System.out.println("\n1 - Voltar");
            number = input.nextInt();

            if (number == 1) {
                sair = true;
            }
        } while (!sair);
        sair = false;
    }

    public void buyMovie() {
        int escolhaCompra;
        String nome = "";

        do {
            console.limpar();
            System.out.println("Pesquise pelo o nome do filme: ");
            do {
                nome = input.nextLine();
            } while (nome == "");

            if (fachada.filmeComprar(nome) != null) {
                if (fachada.getFilmeByNome(nome) != fachada.getFilmeById(fachada.getUserLogado().getId())) {
                    console.limpar();
                    System.out.println("--------------------"
                            + "\n| Filme Encontrado |\n"
                            + "--------------------\n\n"
                            + "Nome: " + fachada.filmeComprar(nome).getNome()
                            + "\nGênero: " + fachada.filmeComprar(nome).getGenero()
                            + "\nDescrição: " + fachada.filmeComprar(nome).getDescricao()
                            + "\n\n"
                            + "\nDeseja comprá-lo?"
                            + "\n1 - Sim"
                            + "\n2 - Não");

                    escolhaCompra = input.nextInt();

                    if (escolhaCompra == 1) {
                        fachada.filmeComprado(fachada.getFilmeByNome(nome), fachada.getUserLogado().getId());
                    } else {
                        console.limpar();
                        System.out.println("--------------------------"
                                + "\n| Aaah não foi dessa vez |\n"
                                + "--------------------------\n\n");
                    }

                } else {
                    console.limpar();
                    System.out.println("------------------------------"
                            + "\n| Este filme já foi comprado |\n"
                            + "------------------------------\n\n");
                }
            } else {
                console.limpar();
                System.out.println("------------------------"
                        + "\n| Filme não encontrado |\n"
                        + "------------------------\n\n");
            }

            System.out.println("1 - Voltar"
                    + "\n2 - Pesquisar Novamente");

            number = input.nextInt();

            if (number == 1)
                sair = true;

        } while (!sair);
        sair = false;
    }

    public void availableMovie() {
        do {
            console.limpar();
            System.out.println("----------------------"
                    + "\n| Filmes Disponíveis |\n"
                    + "----------------------\n\n"
                    + fachada.getAllFilmesBySituation(1)
                    + "\n1 - Voltar");

            number = input.nextInt();

            if (number == 1)
                sair = true;

        } while (!sair);
        sair = false;
    }

    public void addMovie() {
        String name;
        String gender;
        String description;
        int count = 0;

        console.limpar();

        System.out.println("------------------------"
                + "\n| Adicionar Novo Filme |\n"
                + "------------------------\n\n");

        do {
            if (count < 1) {
                System.out.println("\nDigite o nome do filme: ");
            } else {
                System.out.println("\nNome do filme já usado, tente colocar outro:");
            }

            do {
                name = input.nextLine();
            } while (name == "");

            count++;
        } while (fachada.verificaNomeFilme(name));

        count = 0;

        System.out.println("\nDigite o gênero do filme:");
        do {
            gender = input.nextLine();
        } while (gender == "");

        System.out.println("\nDigite a descrição do filme (Em poucas linhas):");
        do {
            description = input.nextLine();
        } while (description == "");

        fachada.addFilme(name, gender, description);
        System.out.println("--------------------"
                + "\n| Filme Adicionado |\n"
                + "--------------------");
    }

    public void editMovieByName(String name) {
        console.limpar();
        menu.editFilmeMenu();

        number = input.nextInt();

        if (number != 6) {
            fachada.editMovie(number, fachada.getFilmeByNome(name));
        }
    }

    public void removeMovieByName(String name) {
        console.limpar();
        if (number != 6) {
            fachada.removeMovie(fachada.getFilmeByNome(name));
        }
    }

    public void editMovieById(int id) {
        console.limpar();
        menu.editFilmeMenu();

        number = input.nextInt();

        if (number != 6) {
            fachada.editMovie(number, fachada.getFilmeById(id));
        }
    }

    public void removeMovieById(int id) {
        console.limpar();
        if (number != 6) {
            fachada.removeMovie(fachada.getFilmeById(id));
        }
    }

    public void editMovie(int type) {
        int idFilme;
        String name;
        String action = type == 1 ? "edit" : "remove";

        do {
            do {
                console.limpar();

                System.out.println("Deseja pesquisar por id ou nome?"
                        + "\n1 - Id"
                        + "\n2 - Nome");

                number = input.nextInt();

                if (number == 1) {
                    console.limpar();

                    System.out.println("Digite o id do filme: ");

                    do {
                        idFilme = input.nextInt();
                    } while (idFilme < 0);

                    if (fachada.getFilmeById(idFilme) != null) {
                        if (action == "edit") {
                            this.editMovieById(idFilme);
                        } else {
                            this.removeMovieById(idFilme);
                        }
                    } else {
                        console.limpar();
                        System.out.println("------------------------"
                                + "\n| Filme não encontrado |\n"
                                + "------------------------\n\n");
                    }

                } else if (number == 2) {
                    console.limpar();
                    System.out.println("Digite o nome do filme: ");
                    do {
                        name = input.nextLine();
                    } while (name == "");

                    if (fachada.getFilmeByNome(name) != null) {
                        if (action == "edit") {
                            this.editMovieByName(name);
                        } else {
                            this.removeMovieByName(name);
                        }
                    } else {
                        console.limpar();
                        System.out.println("------------------------"
                                + "\n| Filme não encontrado |\n"
                                + "------------------------\n\n");
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
        sair = false;
    }
}
