package IU;

import java.util.Scanner;

import Fachada.Loja;

public class FilmeIU {
    LimparConsole console = new LimparConsole();
    Scanner input = new Scanner(System.in);
    private Loja fachada;

    public FilmeIU(Loja fachada) {
        this.fachada = fachada;
    }

    public void compraFilme() {
        int opcao, escolhaCompra;
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

            opcao = input.nextInt();

            if (opcao == 1)
                break;

        } while (true);
    }
}
