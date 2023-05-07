package TestesPacote;

import DadosPacote.*;
import RepositoriosPacote.*;

import java.util.Scanner;

public class SistemaTeste {
	public static void main(String[] args) {

		// Classes
		Menus menu = new Menus();
		Login login = new Login();
		FilmesDAO filmesDAO = new FilmesDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		LimparConsole console = new LimparConsole();

		// Repositorios
		RepositorioUser usuario = new RepositorioUser();
		RepositorioFilme filmes = new RepositorioFilme();
		RepositorioMeusFilmes meusFilmes = new RepositorioMeusFilmes();

		// Libs
		Scanner input = new Scanner(System.in);

		boolean run = true;
		int number;

		// Index

		Usuario userLogado = null;
		Usuario user = new Usuario(0, "Cicero israel", "teste@gmail.com", "123");
		Usuario admin = new Usuario(100, "Admin", "admin@gmail.com", "123");
		admin.setPermissao(1);

		usuario.addUser(user);
		usuario.addUser(admin);

		console.limpar();
		do {

			do {
				System.out.println("-----------------------------------"
						+ "\n| Bem-vindo(a) ao Prime Filmes :) |\n"
						+ "-----------------------------------");

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
						boolean sairLoja = false;

						console.limpar();
						menu.userMenu(userLogado.getPermissao());
						number = input.nextInt();

						switch (number) {
							case 1: {
								do {
									console.limpar();
									menu.lojaMenu();
									int opcaoLoja = input.nextInt();

									switch (opcaoLoja) {
										case 1: {
											int opcao;
											boolean sairListaFilmes = false;
											do {
												console.limpar();
												System.out.println("----------------------"
														+ "\n| Filmes Disponíveis |\n"
														+ "----------------------\n\n"
														+ filmes.getAllFilmesBySituation(1)
														+ "\n1 - Voltar");

												opcao = input.nextInt();

												if (opcao == 1)
													sairListaFilmes = true;

											} while (!sairListaFilmes);

											break;
										}
										case 2: {
											int opcao;
											boolean sairMeusFilmes = false;
											do {
												console.limpar();
												System.out.println("---------------"
														+ "\n| Meus Filmes |\n"
														+ "---------------\n\n"
														+ meusFilmes.getAllFilmes(userLogado.getId())
														+ "\n1 - Voltar");
												opcao = input.nextInt();

												if (opcao == 1)
													sairMeusFilmes = true;

											} while (!sairMeusFilmes);
											break;
										}
										case 3: {
											int opcao, escolhaCompra;
											String nome = "";
											Filmes filmeComprar = null;
											boolean sairCompra = false;

											do {
												console.limpar();
												System.out.println("Pesquise pelo o nome do filme: ");
												do {
													nome = input.nextLine();
												} while (nome == "");

												if (filmes.getFilmeByNome(nome) != null) {
													filmeComprar = filmes.getFilmeByNome(nome);
													if (filmeComprar.getSituaticao() == 1) {
														if (filmeComprar != meusFilmes
																.getFilmeById(userLogado.getId())) {
															console.limpar();
															System.out.println("--------------------"
																	+ "\n| Filme Encontrado |\n"
																	+ "--------------------\n\n"
																	+ "Nome: " + filmeComprar.getNome()
																	+ "\nGênero: " + filmeComprar.getGenero()
																	+ "\nDescrição: " + filmeComprar.getDescricao()
																	+ "\n\n"
																	+ "\nDeseja comprá-lo?"
																	+ "\n1 - Sim"
																	+ "\n2 - Não");

															escolhaCompra = input.nextInt();

															if (escolhaCompra == 1) {
																meusFilmes.addFilme(filmeComprar, userLogado.getId());
																filmesDAO.filmeComprado(filmeComprar, filmes);
															} else {
																console.limpar();
																System.out.println("--------------------------"
																		+ "\n| Aaah não foi dessa vez |\n"
																		+ "--------------------------\n\n");
																filmeComprar = null;
															}
														} else {
															console.limpar();
															System.out.println("------------------------------"
																	+ "\n| Este filme já foi comprado |\n"
																	+ "------------------------------\n\n");
															filmeComprar = null;
														}
													} else {
														console.limpar();
														System.out.println("-----------------------------------------"
																+ "\n| Não foi dessa vez, o que deseja fazer |\n"
																+ "-----------------------------------------\n\n");
														filmeComprar = null;
													}
												} else {
													console.limpar();
													System.out.println("------------------------"
															+ "\n| Filme não encontrado |\n"
															+ "------------------------\n\n");
												}

												if (filmeComprar != null) {
													console.limpar();
													System.out.println("------------------"
															+ "\n| Filme Comprado |\n"
															+ "------------------\n\n");
												}

												System.out.println("1 - Voltar"
														+ "\n2 - Pesquisar Novamente");
												opcao = input.nextInt();

												if (opcao == 1)
													sairCompra = true;

											} while (!sairCompra);

											break;
										}
										case 4: {
											sairLoja = true;
											break;
										}
										default: {
											System.out.println("Opção inválida!");
											break;
										}
									}
								} while (!sairLoja);
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

									mensagem = usuarioDAO.opcoesEditarUser(number, userLogado, usuario);

									if (mensagem == "sair")
										sair = true;

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
						boolean sairLoja = false;
						console.limpar();
						menu.userMenu(userLogado.getPermissao());
						number = input.nextInt();

						switch (number) {
							case 1: {
								do {
									console.limpar();
									menu.lojaMenu();
									int opcaoLoja = input.nextInt();

									switch (opcaoLoja) {
										case 1: {
											int opcao;
											boolean sairListaFilmes = false;
											do {
												console.limpar();
												System.out.println("----------------------"
														+ "\n| Filmes Disponíveis |\n"
														+ "----------------------\n\n"
														+ filmes.getAllFilmesBySituation(1)
														+ "\n1 - Voltar");

												opcao = input.nextInt();

												if (opcao == 1)
													sairListaFilmes = true;

											} while (!sairListaFilmes);

											break;
										}
										case 2: {
											int opcao;
											boolean sairMeusFilmes = false;
											do {
												console.limpar();
												System.out.println("---------------"
														+ "\n| Meus Filmes |\n"
														+ "---------------\n\n"
														+ meusFilmes.getAllFilmes(userLogado.getId())
														+ "\n1 - Voltar");
												opcao = input.nextInt();

												if (opcao == 1)
													sairMeusFilmes = true;

											} while (!sairMeusFilmes);
											break;
										}
										case 3: {
											int opcao, escolhaCompra;
											String nome = "";
											Filmes filmeComprar = null;
											boolean sairCompra = false;

											do {
												console.limpar();
												System.out.println("Pesquise pelo o nome do filme: ");
												do {
													nome = input.nextLine();
												} while (nome == "");

												if (filmes.getFilmeByNome(nome) != null) {
													filmeComprar = filmes.getFilmeByNome(nome);
													if (filmeComprar.getSituaticao() == 1) {
														if (filmeComprar != meusFilmes.getFilmeByNome(nome)) {
															console.limpar();
															System.out.println("--------------------"
																	+ "\n| Filme Encontrado |\n"
																	+ "--------------------\n\n"
																	+ "Nome: " + filmeComprar.getNome()
																	+ "\nGênero: " + filmeComprar.getGenero()
																	+ "\nDescrição: " + filmeComprar.getDescricao()
																	+ "\n\n"
																	+ "\nDeseja comprá-lo?"
																	+ "\n1 - Sim"
																	+ "\n2 - Não");

															escolhaCompra = input.nextInt();

															if (escolhaCompra == 1) {
																meusFilmes.addFilme(filmeComprar, userLogado.getId());
																filmesDAO.filmeComprado(filmeComprar, filmes);
															} else {
																console.limpar();
																System.out.println("--------------------------"
																		+ "\n| Aaah não foi dessa vez |\n"
																		+ "--------------------------\n\n");
																filmeComprar = null;
															}
														} else {
															console.limpar();
															System.out.println("------------------------------"
																	+ "\n| Este filme já foi comprado |\n"
																	+ "------------------------------\n\n");
															filmeComprar = null;
														}
													} else {
														console.limpar();
														System.out.println("-----------------------------------------"
																+ "\n| Não foi dessa vez, o que deseja fazer |\n"
																+ "-----------------------------------------\n\n");
														filmeComprar = null;
													}
												} else {
													console.limpar();
													System.out.println("------------------------"
															+ "\n| Filme não encontrado |\n"
															+ "------------------------\n\n");
												}

												if (filmeComprar != null) {
													console.limpar();
													System.out.println("------------------"
															+ "\n| Filme Comprado |\n"
															+ "------------------\n\n");
												}

												System.out.println("1 - Voltar"
														+ "\n2 - Pesquisar Novamente");
												opcao = input.nextInt();

												if (opcao == 1)
													sairCompra = true;

											} while (!sairCompra);

											break;
										}
										case 4: {
											sairLoja = true;
											break;
										}
										default: {
											System.out.println("Opção inválida!");
											break;
										}
									}
								} while (!sairLoja);
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

									mensagem = usuarioDAO.opcoesEditarUser(number, userLogado, usuario);

									if (mensagem == "sair") {
										mensagem = "";
										sair = true;
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
											int opcao;
											int idUser;
											String emailUser;
											Usuario userAtualizar = null;
											boolean sairAtualizarUser = false;

											do {
												do {
													console.limpar();
													System.out.println("Deseja pesquisar por email ou id?"
															+ "\n1 - Id"
															+ "\n2 - Email");
													opcao = input.nextInt();
													if (opcao == 1) {
														console.limpar();
														System.out.println("Digite o id do usuário: ");

														do {
															idUser = input.nextInt();
														} while (idUser < 0);

														if (usuario.getUserById(idUser) != null) {
															userAtualizar = usuario.getUserById(idUser);
														} else {
															console.limpar();
															System.out.println("--------------------------"
																	+ "\n| Usuário não encontrado |\n"
																	+ "--------------------------\n\n");
														}

													} else if (opcao == 2) {
														console.limpar();
														System.out.println("Digite o email do usuário: ");
														do {
															emailUser = input.nextLine();
														} while (emailUser == "");

														if (usuario.getUserByEmail(emailUser) != null) {
															userAtualizar = usuario.getUserByEmail(emailUser);
														} else {
															console.limpar();
															System.out.println("--------------------------"
																	+ "\n| Usuário não encontrado |\n"
																	+ "--------------------------\n\n");
														}
													}
												} while (opcao < 1 || opcao > 2);

												if (userAtualizar != null) {
													console.limpar();
													menu.editUserMenu();

													number = input.nextInt();

													mensagem = usuarioDAO.opcoesEditarUser(number, userAtualizar,
															usuario);

													sairAtualizarUser = true;
												} else {
													mensagem = "";

													System.out.println("Deseja tentar novamente ou sair?"
															+ "\n1 - Tentar Novamente"
															+ "\n2 - Sair");
													opcao = input.nextInt();

													if (opcao == 2)
														sairAtualizarUser = true;
												}
											} while (!sairAtualizarUser);

											break;
										}
										case 4: {
											int opcao;
											int idUser;
											String emailUser;
											Usuario userAtualizar = null;
											boolean sairRemoverUser = false;

											do {
												console.limpar();

												System.out.println("Deseja pesquisar por email ou id?"
														+ "\n1 - Id"
														+ "\n2 - Email");

												opcao = input.nextInt();

												if (opcao == 1) {
													console.limpar();
													System.out.println("Digite o id do usuário: ");

													do {
														idUser = input.nextInt();
													} while (idUser < 0);

													if (usuario.getUserById(idUser) != null) {
														userAtualizar = usuario.getUserById(idUser);
													} else {
														console.limpar();
														System.out.println("--------------------------"
																+ "\n| Usuário não encontrado |\n"
																+ "--------------------------\n\n");
													}

												} else if (opcao == 2) {
													console.limpar();
													System.out.println("Digite o email do usuário: ");
													do {
														emailUser = input.nextLine();
													} while (emailUser == "");

													if (usuario.getUserByEmail(emailUser) != null) {
														userAtualizar = usuario.getUserByEmail(emailUser);
													} else {
														console.limpar();
														System.out.println("--------------------------"
																+ "\n| Usuário não encontrado |\n"
																+ "--------------------------\n\n");
													}
												}

												if (userAtualizar != null) {
													usuario.deleteUser(userAtualizar);

													mensagem = "--------------------"
															+ "\n| Usuário Removido |\n"
															+ "--------------------";

													sairRemoverUser = true;
												} else {
													mensagem = "";

													System.out.println("Deseja tentar novamente ou sair?"
															+ "\n1 - Tentar Novamente"
															+ "\n2 - Sair");
													opcao = input.nextInt();

													if (opcao == 2)
														sairRemoverUser = true;
												}

											} while (!sairRemoverUser);
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
											boolean sairListaFilmes = false;
											do {
												console.limpar();
												System.out.println(filmes.getAllFilmes());

												System.out.println("\n1 - Voltar");
												number = input.nextInt();

												if (number == 1) {
													sairListaFilmes = true;
												}
											} while (!sairListaFilmes);
											break;
										}
										case 2: {
											console.limpar();

											filmes.addFilme(filmesDAO.addFilme(filmes));

											mensagem = "--------------------"
													+ "\n| Filme Adicionado |\n"
													+ "--------------------";
											break;
										}
										case 3: {
											console.limpar();
											int idFilme, opcao;
											String nome;
											Filmes filmeAtualizar = null;
											boolean sairEditarFilme = false;

											do {
												do {
													console.limpar();

													System.out.println("Deseja pesquisar por id ou nome?"
															+ "\n1 - Id"
															+ "\n2 - Nome");

													opcao = input.nextInt();

													if (opcao == 1) {
														console.limpar();

														System.out.println("Digite o id do filme: ");

														do {
															idFilme = input.nextInt();
														} while (idFilme < 0);

														if (filmes.getFilmeById(idFilme) != null) {
															filmeAtualizar = filmes.getFilmeById(idFilme);
														} else {
															console.limpar();
															System.out.println("------------------------"
																	+ "\n| Filme não encontrado |\n"
																	+ "------------------------\n\n");
														}

													} else if (opcao == 2) {
														console.limpar();
														System.out.println("Digite o nome do filme: ");
														do {
															nome = input.nextLine();
														} while (nome == "");

														if (filmes.getFilmeByNome(nome) != null) {
															filmeAtualizar = filmes.getFilmeByNome(nome);
														} else {
															console.limpar();
															System.out.println("------------------------"
																	+ "\n| Filme não encontrado |\n"
																	+ "------------------------\n\n");
														}
													}
												} while (opcao < 1 || opcao > 2);

												if (filmeAtualizar != null) {
													console.limpar();
													menu.editFilmeMenu();

													number = input.nextInt();

													mensagem = filmesDAO.opcoesEditarFilmes(number, filmeAtualizar,
															filmes);

													sairEditarFilme = true;
												} else {
													System.out.println("Deseja tentar novamente ou sair?"
															+ "\n1 - Tentar Novamente"
															+ "\n2 - Sair");

													opcao = input.nextInt();

													if (opcao == 2)
														sairEditarFilme = true;
												}
											} while (!sairEditarFilme);

											break;
										}
										case 4: {
											console.limpar();
											int idFilme, opcao;
											String nome;
											Filmes filmeRemover = null;
											boolean sairRemoverFilme = false;

											do {
												do {
													console.limpar();

													System.out.println("Deseja pesquisar por id ou nome?"
															+ "\n1 - Id"
															+ "\n2 - Nome");

													opcao = input.nextInt();

													if (opcao == 1) {
														console.limpar();

														System.out.println("Digite o id do filme: ");

														do {
															idFilme = input.nextInt();
														} while (idFilme < 0);

														if (filmes.getFilmeById(idFilme) != null) {
															filmeRemover = filmes.getFilmeById(idFilme);
														} else {
															console.limpar();
															System.out.println("------------------------"
																	+ "\n| Filme não encontrado |\n"
																	+ "------------------------\n\n");
														}

													} else if (opcao == 2) {
														console.limpar();
														System.out.println("Digite o nome do filme: ");
														do {
															nome = input.nextLine();
														} while (nome == "");

														if (filmes.getFilmeByNome(nome) != null) {
															filmeRemover = filmes.getFilmeByNome(nome);
														} else {
															console.limpar();
															System.out.println("------------------------"
																	+ "\n| Filme não encontrado |\n"
																	+ "------------------------\n\n");
														}
													}
												} while (opcao < 1 || opcao > 2);

												if (filmeRemover != null) {
													filmes.deleteFilme(filmeRemover);
													mensagem = "------------------"
															+ "\n| Filme Removido |\n"
															+ "------------------";

													sairRemoverFilme = true;
												} else {
													mensagem = "";
													System.out.println("Deseja tentar novamente ou sair?"
															+ "\n1 - Tentar Novamente"
															+ "\n2 - Sair");

													opcao = input.nextInt();

													if (opcao == 2)
														sairRemoverFilme = true;
												}
											} while (!sairRemoverFilme);
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

		input.close();
	}
}
