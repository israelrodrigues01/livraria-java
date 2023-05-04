package DadosPacote;

public class Menus {

	public void loginMenu() {
		System.out.println(""
				+ "\n1 - Login"
				+ "\n2 - Cadastro"
				+ "\n3 - Sair");
	}

	public void userMenu() {
		System.out.println("------------------"
				+ "\n| Menu Principal |\n"
				+ "------------------\n\n"
				+ "\n1 - Ver filmes"
				+ "\n2 - Perfil"
				+ "\n3 - Editar usuário"
				+ "\n4 - Logout");
	}

	public void editUserMenu() {
		System.out.println("------------------"
				+ "\n| Editar Usuário |\n"
				+ "------------------\n\n"
				+ "\n1 - Editar nome"
				+ "\n2 - Editar email"
				+ "\n3 - Editar senha"
				+ "\n4 - Editar tudo"
				+ "\n5 - Voltar");
	}
}
