package TestesPacote;

import DadosPacote.*;
import RepositoriosPacote.*;

import java.util.Scanner;

public class SistemaTeste {
	public static void main(String[] args) {

		// Classes
		LimparConsole console = new LimparConsole();
		Menus menu = new Menus();
		Login login = new Login();

		// Repositorios
		RepositorioUser usuario = new RepositorioUser();
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		// Libs
		Scanner input = new Scanner(System.in);

		boolean run = true;
		int number;

		// Index

		System.out.println("Bem-vindo(a) ao Prime Filmes :)");

		Usuario userLogado = null;
		Usuario user = new Usuario(0, "Cicero israel", "teste@gmail.com", "123");
		Usuario admin = new Usuario(100, "Admin", "admin@gmail.com", "123");
		admin.setPermissao(1);

		usuario.addUser(user);
		usuario.addUser(admin);

		do {

			do {
				menu.loginMenu();
				number = input.nextInt();

				switch (number) {
					case 1: {
						userLogado = login.acessar(usuario);
						break;
					}
					case 2: {

						usuario.addUser(login.cadastro(usuario));
						break;
					}
					case 3: {
						run = false;
						break;
					}
					default:
						System.out.println("Opção invalida");
						break;
				}

			} while (!login.isLogado() && run);

			if (login.isLogado()) {
				if (userLogado.getPermissao() == 0) {
					do {

						console.limpar();
						menu.userMenu(userLogado.getPermissao());
						number = input.nextInt();

						switch (number) {
							case 1: {
								System.out.println("Listagem dos filmes");
								break;
							}
							case 2: {
								boolean sairPerfil = false;
								do {
									console.limpar();
									System.out.println("---------------------"
											+ "\n| Perfil do Usuário |\n"
											+ "---------------------\n\n");

									System.out.println(""
											+ "Nome: " + userLogado.getNome()
											+ "\nEmail: " + userLogado.getEmail()
											+ "\nSenha: " + userLogado.getSenha());

									System.out.println("\n1 - Voltar");
									number = input.nextInt();

									if (number == 1) {
										sairPerfil = true;
									}
								} while (!sairPerfil);
								break;
							}
							case 3: {
								boolean sair = false;
								String mensagem = "";
								do {
									console.limpar();

									if (mensagem != "") {
										System.out.println(mensagem + "\n\n");
									}

									menu.editUserMenu();

									number = input.nextInt();

									switch (number) {
										case 1: {
											console.limpar();
											usuarioDAO.editarNome(userLogado);
											mensagem = "----------------"
													+ "\n| Nome editado |\n"
													+ "----------------";
											break;
										}
										case 2: {
											console.limpar();
											usuarioDAO.editarEmail(userLogado);
											mensagem = "-----------------"
													+ "\n| Email editado |\n"
													+ "-----------------";
											break;
										}
										case 3: {
											console.limpar();
											usuarioDAO.editarSenha(userLogado);
											mensagem = "-----------------"
													+ "\n| Senha editada |\n"
													+ "-----------------";
											break;
										}
										case 4: {
											console.limpar();
											usuarioDAO.editarUser(userLogado);
											break;
										}
										case 5: {
											sair = true;
											console.limpar();
											break;
										}
										default: {
											System.out.println("Opção invalida");
											break;
										}
									}
								} while (!sair);

								break;
							}
							case 4: {
								login.logout();
								console.limpar();
								break;
							}
							default: {
								System.out.println("Opção invalida");
								break;
							}
						}

					} while (login.isLogado());
				} else if (userLogado.getPermissao() == 1) {
					do {

						console.limpar();
						menu.userMenu(userLogado.getPermissao());
						number = input.nextInt();

						switch (number) {
							case 1: {
								System.out.println("Listagem dos filmes");
								break;
							}
							case 2: {
								boolean sairPerfil = false;
								do {
									console.limpar();
									System.out.println("---------------------"
											+ "\n| Perfil do Usuário |\n"
											+ "---------------------\n\n");

									System.out.println(""
											+ "Nome: " + userLogado.getNome()
											+ "\nEmail: " + userLogado.getEmail()
											+ "\nSenha: " + userLogado.getSenha());

									System.out.println("\n1 - Voltar");
									number = input.nextInt();

									if (number == 1) {
										sairPerfil = true;
									}
								} while (!sairPerfil);
								break;
							}
							case 3: {
								boolean sair = false;
								String mensagem = "";
								do {
									console.limpar();

									if (mensagem != "") {
										System.out.println(mensagem + "\n\n");
									}

									menu.editUserMenu();

									number = input.nextInt();

									switch (number) {
										case 1: {
											console.limpar();
											usuarioDAO.editarNome(userLogado);
											mensagem = "----------------"
													+ "\n| Nome editado |\n"
													+ "----------------";
											break;
										}
										case 2: {
											console.limpar();
											usuarioDAO.editarEmail(userLogado);
											mensagem = "-----------------"
													+ "\n| Email editado |\n"
													+ "-----------------";
											break;
										}
										case 3: {
											console.limpar();
											usuarioDAO.editarSenha(userLogado);
											mensagem = "-----------------"
													+ "\n| Senha editada |\n"
													+ "-----------------";
											break;
										}
										case 4: {
											console.limpar();
											usuarioDAO.editarUser(userLogado);
											break;
										}
										case 5: {
											sair = true;
											console.limpar();
											break;
										}
										default: {
											System.out.println("Opção invalida");
											break;
										}
									}
								} while (!sair);

								break;
							}
							case 4: {
								boolean sair = false;
								String mensagem = "";
								do {
									console.limpar();

									if (mensagem != "") {
										System.out.println(mensagem + "\n\n");
									}

									menu.crudUser();

									number = input.nextInt();

									switch (number) {
										case 1: {
											boolean sairListaUsers = false;
											do {
												console.limpar();
												System.out.println(usuario.getAllUsers());

												System.out.println("\n1 - Voltar");
												number = input.nextInt();

												if (number == 1) {
													sairListaUsers = true;
												}
											} while (!sairListaUsers);
											break;
										}
										case 2: {
											console.limpar();
											usuario.addUser(usuarioDAO.addUser(usuario));
											mensagem = "----------------------"
													+ "\n| Usuário Adicionado |\n"
													+ "----------------------";
											break;
										}
										case 3: {
											console.limpar();
											mensagem = "----------------------"
													+ "\n| Usuário Atualizado |\n"
													+ "----------------------";
											break;
										}
										case 4: {
											console.limpar();
											mensagem = "--------------------"
													+ "\n| Usuário Removido |\n"
													+ "--------------------";
											break;
										}
										case 5: {
											sair = true;
											console.limpar();
											break;
										}
										default: {
											System.out.println("Opção invalida");
											break;
										}
									}
								} while (!sair);
								break;
							}
							case 5: {
								boolean sair = false;
								String mensagem = "";
								do {
									console.limpar();

									if (mensagem != "") {
										System.out.println(mensagem + "\n\n");
									}

									menu.crudFilme();

									number = input.nextInt();

									switch (number) {
										case 1: {
											console.limpar();
											mensagem = "Listar Filmes";
											break;
										}
										case 2: {
											console.limpar();
											mensagem = "--------------------"
													+ "\n| Filme Adicionado |\n"
													+ "--------------------";
											break;
										}
										case 3: {
											console.limpar();
											mensagem = "--------------------"
													+ "\n| Filme Atualizado |\n"
													+ "--------------------";
											break;
										}
										case 4: {
											console.limpar();
											mensagem = "------------------"
													+ "\n| Filme Removido |\n"
													+ "------------------";
											break;
										}
										case 5: {
											sair = true;
											console.limpar();
											break;
										}
										default: {
											System.out.println("Opção invalida");
											break;
										}
									}
								} while (!sair);
								break;
							}
							case 6: {
								login.logout();
								console.limpar();
								break;
							}
							default: {
								System.out.println("Opção invalida");
								break;
							}
						}

					} while (login.isLogado());
				}
			}

			// Finish System
			if (!run) {
				console.limpar();
				System.out.println("\n\n"
						+ "Obrigado por usar nosso sistema, volte sempre!"
						+ "");
			}

		} while (run);
	}
}
