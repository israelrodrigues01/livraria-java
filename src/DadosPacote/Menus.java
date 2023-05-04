package DadosPacote;
import java.util.Scanner;

public class Menus {
	
	public void loginMenu() {
		Scanner scanner = new Scanner(System.in);
		int opcao = 0;
		
		System.out.println(""
				+ "\n1 - Login"
				+ "\n2 - Cadastro"
				+ "\n3 - Sair");	
		
	}
	public void adminMenu() {
		
		int opcao = 0;
		
		System.out.println(""
				+ "\n1 - Buscar Por Filme"
				+ "\n2 - Adicionar filme"
				+ "\n3 - Excluir filme"
				+ "\n4 - Atualizaar filme"
				+ "\n5 - Comprar Filme"
				+ "\n6 - Buscar usuário"
				+ "\n7 - atualizar Usuários"
				+ "\n8 - Remover usuátia");	
		
	}
	
	public void userMenus() {
		System.out.println(""
				+ "\n1 - Buscar Por Filme"
				+ "\n2 - Comprar filme"
				);	
		
	}
	}
	
}
