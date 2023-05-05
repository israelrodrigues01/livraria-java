// package TestesPacote;

// import DadosPacote.Menus;
// import DadosPacote.Login;

// import java.util.Scanner;

// public class LoginTeste {

// 	public void logar() {
// 		Menus menu = new Menus();
// 		Login login = new Login();
		
// 		Scanner input = new Scanner(System.in);
		
// 		System.out.println("============ Bem-vindo ao Play Filmes Store ============\n\n");
		
// 		do {
// 			menu.loginMenu();
// 			int number = input.nextInt();
			
// 			switch (number) {
// 			case 1: {
// 				login.acessar();
// 				break;
// 			}
// 			case 2: {
// 				login.cadastro();
// 				break;
// 			}
// 			default:
// 				System.out.println("Opção invalida");
// 				break;
// 			}
			
// 			System.out.println(login.isLogado());
			
// 		}while(!login.isLogado());
		
// 		input.close();
		
// 	}
	
// }
