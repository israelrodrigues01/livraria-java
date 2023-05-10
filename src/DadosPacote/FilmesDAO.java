package DadosPacote;

import RepositoriosPacote.RepositorioFilme;

import java.util.Scanner;

public class FilmesDAO {
    private static int idFilme = 0;

    Verificacoes verificar = new Verificacoes();

    Scanner input = new Scanner(System.in);
    LimparConsole console = new LimparConsole();

    public Filmes addFilme(RepositorioFilme filme) {
        String nome;
        String genero;
        String descricao;
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
                nome = input.nextLine();
            } while (nome == "");

            count++;
        } while (verificar.verificaNomeFilme(filme, nome));

        count = 0;

        System.out.println("\nDigite o gênero do filme:");
        do {
            genero = input.nextLine();
        } while (genero == "");

        System.out.println("\nDigite a descrição do filme (Em poucas linhas):");
        do {
            descricao = input.nextLine();
        } while (descricao == "");

        idFilme += 1;

        Filmes newFilme = new Filmes(idFilme, nome, genero, descricao, 1);

        return newFilme;
    }

    public void editarNome(Filmes filme, RepositorioFilme filmes) {
        String nome;
        int count = 0;

        do {
            if (count < 1) {
                System.out.println("\nNovo nome do filme: ");
            } else {
                System.out.println("\nNome do filme já usado, tente colocar outro:");
            }

            do {
                nome = input.nextLine();
            } while (nome == "");

            count++;
        } while (verificar.verificaNomeFilme(filmes, nome));

        filme.setNome(nome);
    }

    public void editarGenero(Filmes filme) {
        String genero;

        System.out.println("\nNovo gênero do filme:");
        do {
            genero = input.nextLine();
        } while (genero == "");

        filme.setGenero(genero);
    }

    public void editarDescricao(Filmes filme) {
        String descricao;

        System.out.println("\nNova descrição do filme (Em poucas linhas):");
        do {
            descricao = input.nextLine();
        } while (descricao == "");

        filme.setDescricao(descricao);
    }

    public void editarSituacao(Filmes filme) {
        int situacao, count = 0;

        System.out.println("\n* Filmes inativos não aparecem na lista dos compradores!"
                + "\nSituação do filme:"
                + "\n0 - Inativo"
                + "\n1 - Ativo");
        do {
            if (count > 1) {
                System.out.println("\n* Filmes inativos não aparecem na lista dos compradores!"
                        + "\nPor favor, escolha a situação entre:"
                        + "\n0 - Inativo"
                        + "\n1 - Ativo");
            }

            situacao = input.nextInt();
            count++;
        } while (situacao < 0);

        filme.setSituaticao(situacao);
    }

    public void editarFilme(Filmes filme, RepositorioFilme filmes) {
        this.editarNome(filme, filmes);
        this.editarGenero(filme);
        this.editarDescricao(filme);
        this.editarSituacao(filme);
    }

    public String opcoesEditarFilmes(int opcao, Filmes filme, RepositorioFilme filmes) {
        String mensagem = "";
        switch (opcao) {
            case 1: {
                console.limpar();
                this.editarNome(filme, filmes);
                mensagem = "----------------"
                        + "\n| Nome editado |\n"
                        + "----------------";
                break;
            }
            case 2: {
                console.limpar();
                this.editarGenero(filme);
                mensagem = "";
                break;
            }
            case 3: {
                console.limpar();
                this.editarDescricao(filme);
                mensagem = "";
                break;
            }
            case 4: {
                console.limpar();
                this.editarSituacao(filme);
                mensagem = "";
                break;
            }
            case 5: {
                console.limpar();
                this.editarFilme(filme, filmes);
                mensagem = "";
                break;
            }
            case 6: {
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

    public void filmeComprado(Filmes filmeComprar, RepositorioFilme filmes) {
        filmes.deleteFilme(filmeComprar);
    }
}
