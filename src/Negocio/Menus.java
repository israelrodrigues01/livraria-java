package Negocio;

public class Menus {

	public void loginMenu() {
		System.out.println(""
				+ "\n1 - Login"
				+ "\n2 - Cadastro"
				+ "\n3 - Sair");
	}

	public void userMenu(int permissao) {
		String cabecalho;
		String opcoes;

		opcoes = "\n1 - Loja"
				+ "\n2 - Perfil"
				+ "\n3 - Editar usuário";

		if (permissao == 1) {
			cabecalho = "------------------------"
					+ "\n| Menu Principal ADMIN |\n"
					+ "------------------------\n\n";
			opcoes += "\n4 - CRUD Usuários"
					+ "\n5 - CRUD Filmes"
					+ "\n6 - Logout";
		} else {
			cabecalho = "------------------"
					+ "\n| Menu Principal |\n"
					+ "------------------\n\n";
			opcoes += "\n4 - Logout";
		}

		System.out.println(cabecalho + opcoes);
	}

	public void lojaMenu() {
		System.out.println("------------------"
				+ "\n| Loja de Filmes |\n"
				+ "------------------\n\n"
				+ "\n1 - Filmes disponíveis"
				+ "\n2 - Meus filmes"
				+ "\n3 - Comprar filme"
				+ "\n4 - Voltar");
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

	public void editFilmeMenu() {
		System.out.println("------------------"
				+ "\n| Editar Filme |\n"
				+ "------------------\n\n"
				+ "\n1 - Editar nome"
				+ "\n2 - Editar genero"
				+ "\n3 - Editar descricao"
				+ "\n4 - Editar situacao"
				+ "\n5 - Editar tudo"
				+ "\n6 - Voltar");
	}
}