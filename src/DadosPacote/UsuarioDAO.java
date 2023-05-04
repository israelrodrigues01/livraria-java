package DadosPacote;

import DadosPacote.Usuario;
import RepositoriosPacote.RepositorioUser;

import java.util.Scanner;

public class UsuarioDAO {

    Verificacoes verificar = new Verificacoes();

    Scanner input = new Scanner(System.in);
    LimparConsole console = new LimparConsole();

    private static int idUser = 0;

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
        nome = input.nextLine();

        do {
            if (count < 1) {
                System.out.println("\nDigite seu melhor email: ");
            } else {
                System.out.println("\nNão foi possível acessar com este email, tente usar outro: ");
            }
            email = input.nextLine();
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
        System.out.println("--------------------------------------------------------------------------\n"
                + "| Cadastro realizado com sucesso, agora faça login para acessar a conta! |\n"
                + "--------------------------------------------------------------------------\n\n");

        return usuario;
    }

    public void editarNome(Usuario user) {
        System.out.println("Adicione seu novo nome de usuário: ");
        String nome = input.nextLine();

        user.setNome(nome);
    }

    public void editarEmail(Usuario user) {
        System.out.println("Adicione seu novo email de login: ");
        String email = input.nextLine();

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
            senha = input.nextLine();

            System.out.println("\nConfirme sua senha: ");
            confirmSenha = input.nextLine();

            count++;
        } while (!senha.equals(confirmSenha));

        user.setSenha(senha);
    }

    public void editarUser(Usuario user) {
        this.editarNome(user);
        System.out.println("\n");
        this.editarEmail(user);
        System.out.println("\n");
        this.editarSenha(user);
    }
}
