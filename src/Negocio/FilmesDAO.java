package Negocio;

import java.util.Scanner;

import IU.LimparConsole;
import Repositorios.IRepositorioFilme;

public class FilmesDAO {
    private static int idFilme = 0;

    Verificacoes verificar = new Verificacoes();

    Scanner input = new Scanner(System.in);
    LimparConsole console = new LimparConsole();

    public void addFilme(String name, String gender, String description, IRepositorioFilme filmes) {
        if (!verificar.verificaNomeFilme(filmes, name)) {
            idFilme += 1;
            Filmes newFilme = new Filmes(idFilme, name, gender, description, 1);
            filmes.addFilme(newFilme);
        }
    }

    public void removeMovie(Filmes filme, IRepositorioFilme filmes) {
        filmes.deleteFilme(filme);
    }

    public void editarNome(Filmes filme, IRepositorioFilme filmes) {
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

    public void editarFilme(Filmes filme, IRepositorioFilme filmes) {
        this.editarNome(filme, filmes);
        this.editarGenero(filme);
        this.editarDescricao(filme);
        this.editarSituacao(filme);
    }

    public void opcoesEditarFilmes(int opcao, Filmes filme, IRepositorioFilme filmes) {
        switch (opcao) {
            case 1: {
                console.limpar();
                this.editarNome(filme, filmes);
                break;
            }
            case 2: {
                console.limpar();
                this.editarGenero(filme);
                break;
            }
            case 3: {
                console.limpar();
                this.editarDescricao(filme);
                break;
            }
            case 4: {
                console.limpar();
                this.editarSituacao(filme);
                break;
            }
            case 5: {
                console.limpar();
                this.editarFilme(filme, filmes);
                break;
            }
            default: {
                System.out.println("Opção invalida");
                break;
            }
        }
    }

    public void filmeComprado(Filmes filmeComprar, IRepositorioFilme filmes) {
        filmes.deleteFilme(filmeComprar);
    }
}
