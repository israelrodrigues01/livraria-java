package IU;

import java.util.Scanner;

import Fachada.Loja;

public class LoginIU {
    private LimparConsole console = new LimparConsole();
    private Scanner input = new Scanner(System.in);
    private Loja fachada;

    public LoginIU(Loja fachada) {
        this.fachada = fachada;
    }

    public void acessar() {
        String email, senha;
        int count = 0;

        console.limpar();

        System.out.println("---------"
                + "\n| Login |\n"
                + "---------\n\n"
                + "\nDigite seu email: ");
        do {
            email = input.nextLine();
        } while (email == "");

        if (fachada.isEmail(email)) {
            System.out.println("\nDigite sua senha: ");
            do {
                senha = input.nextLine();
            } while (senha == "");

            while (!(fachada.verificarSenha(senha))) {
                if (count < 5) {
                    console.limpar();
                    System.out.println("----------------------------------------"
                            + "\n| Por favor, digite a senha novamente: |\n"
                            + "----------------------------------------\n\n");
                    senha = input.nextLine();
                } else {
                    console.limpar();
                    System.out.println("----------------------------------------------------------------"
                            + "\n| Não foi possivel conectar na sua conta, tente outro momento! |\n"
                            + "----------------------------------------------------------------\n\n");
                    break;
                }

                count++;
            }

            if (count < 5) {
                fachada.acessarConta(email, senha);
            }

        } else {
            console.limpar();
            System.out.println("------------------------------------"
                    + "\n| Cadastre-se antes de fazer Login |\n"
                    + "------------------------------------\n\n");
        }
    }

    public void cadastro() {
        String nome;
        String email;
        String senha;
        String confirmSenha;
        int count = 0;
        boolean sair = false;

        do {
            console.limpar();
            System.out.println("------------"
                    + "\n| Cadastro |\n"
                    + "------------\n\n"
                    + "Digite seu nome: ");
            do {
                nome = input.nextLine();
            } while (nome == "");

            System.out.println("\nDigite seu melhor email: ");
            do {
                email = input.nextLine();
            } while (email == "");

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

            try {
                fachada.cadastroConta(nome, email, senha, 0);
                sair = true;

                console.limpar();
                System.out.println("--------------------------------------------------------------------------"
                        + "\n| Cadastro realizado com sucesso, agora faça login para acessar a conta! |\n"
                        + "--------------------------------------------------------------------------\n\n");
            } catch (Exception e) {
                sair = false;
            }
        } while (!sair);
    }
}
