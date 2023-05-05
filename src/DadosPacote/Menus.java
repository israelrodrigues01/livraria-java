package DadosPacote;

public class Menus {

	public void loginMenu() {
		System.out.println(""
				+ "\n1 - Login"
				+ "\n2 - Cadastro"
				+ "\n3 - Sair");
	}

	public void userMenu(int permissao) {
		if (permissao == 0) {
			System.out.println("------------------"
					+ "\n| Menu Principal |\n"
					+ "------------------\n\n"
					+ "\n1 - Ver filmes"
					+ "\n2 - Perfil"
					+ "\n3 - Editar usuário"
					+ "\n4 - Logout");
		} else {
			System.out.println("------------------------"
					+ "\n| Menu Principal ADMIN |\n"
					+ "------------------------\n\n"
					+ "\n1 - Ver filmes"
					+ "\n2 - Perfil"
					+ "\n3 - Editar usuário"
					+ "\n4 - CRUD Usuários"
					+ "\n5 - CRUD Filmes"
					+ "\n6 - Logout");
		}
	}

	public void crudUser() {
		System.out.println("----------------------"
				+ "\n| CRUD Usuário ADMIN |\n"
				+ "----------------------\n\n"
				+ "\n1 - Listar Usuários"
				+ "\n2 - Adicionar Usuário"
				+ "\n3 - Atualizar Usuário"
				+ "\n4 - Remover Usuário"
				+ "\n5 - Voltar");
	}

	public void crudFilme() {
		System.out.println("--------------------"
				+ "\n| CRUD Filme ADMIN |\n"
				+ "--------------------\n\n"
				+ "\n1 - Listar Filmes"
				+ "\n2 - Adicionar Filme"
				+ "\n3 - Atualizar Filme"
				+ "\n4 - Remover Filme"
				+ "\n5 - Voltar");
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
