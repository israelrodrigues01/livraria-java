Universidade Federal do Cariri
Curso: Bacharelado em Ciência da Computação.
Disciplina: Programação Orientada à Objetos.
Professora: Paola Accioly.
Equipe: Cícero Israel.
 
Loja de Filmes
1. Descrição do sistema
O sistema desenvolvido consiste em um ambiente de venda e comercialização de filmes. Com o objetivo de facilitar a venda de seus produtos por lojas físicas e expandir seus negócios, tornando-os mais escaláveis. 
O programa possibilita o cadastro e login de novos usuários, onde será disponível um menu no qual pode buscar os filmes que deseja comprar ou acessar a lista completa de filmes. Além disso, ele poderá editar suas informações, por exemplo, sua conta, nome, senha e outros dados. Assim, o usuário tem total controle de seus dados e informações sobre os filmes a qual deseja comprar. 
O administrador faz o controle de todo o sistema, sendo ele responsável por adicionar filmes, atualizar e deletar. Outra funcionalidade será o controle de novos usuários e os já cadastrados no sistema. Podendo adicionar um novo Admin ou um usuário normal. E, como usuário também, poderá fazer todas ações que o usuário comum, como comprar filmes, ver as listas, etc.
2. Backlog
Funcionalidade
Responsável
Classes e Atributos
Israel
CRUD Filme
Israel
CRUD Usuário
Israel
Login e Cadastro
Israel


3. Arquitetura do Sistema	


Figura 1: diagrama de casos de uso

Para resumir as interações e os detalhes dos usuários com o sistema, faz-se necessário a apresentação do diagrama de caso de uso acima. No diagrama temos o usuário/Cliente do sistema de loja de filmes e poderá realizar as operações de Busca e compra de filmes. Além disso, o Administrador interage com o sistema sendo capaz de realizar as mesmas operações de busca e compra de filmes que o usuário possui e, além dessas funções, pode gerenciar filmes: atualizar, deletar e inserir e Gerenciar Usuário: adicionar, editar, remover usuários.  

Figura 2: diagrama de classes (Fachada)



Figura 3: diagrama de classes (Dados)

Link do diagrama completo: Diagrama de Classes

O diagrama de classes acima descreve a estrutura que será seguida pelo sistema. O esquema contém as classes Filmes e Usuário, com os seus respectivos atributos e métodos. Atributos e Métodos para as classe Filmes e Usuarios.

Agora, a nova atualização do sistema trouxe o projeto com camadas, facilitando na melhoria do código e na sua manutenção. As camadas foram divididas em: 
IU (Interface gráfica)
Fachada
Dados

E, para melhorar ainda mais e deixar nosso software mais elegante, trazemos um pacote que traz classes bem específicas, que são as Exceções, tornando os erros visíveis ao Usuário e o Sistema.

3. Teste do Sistema
No sistema haverá um teste principal na qual tem dois usuários cadastrados de início, para caso não queira cadastrar possa logar de primeira. Os usuários já adicionados são: usuário normal - teste@gmail.com e admin - admin@gmail.com. Ambas as contas têm a mesma senha: 123.

Para usar o sistema é simples, após logar em sua conta aparecerá o menu informando o fluxo no qual deseja seguir, por exemplo: Loja de filmes, seu perfil, editar seu perfil e deslogar da conta. De acordo com sua conta essas informações podem mudar, por exemplo, a conta Admin tem informações a mais, que são: CRUD Usuários, CRUD filmes. 

Na loja, os filmes disponíveis vão indicar quais filmes você pode comprar, mas caso esteja faça, o admin deverá adicionar filmes para que sejam comprados. Então, para testar a opção de compra de filmes e a loja no geral, logar na conta Admin fará mais sentido, onde adicionando os filmes fará com que o fluxo da loja seja disponível.

4. Atualização dos membros
A Ivna necessitou sair bem no início do projeto, com foco em aprender melhor os conceitos de POO e não prejudicar o projeto Loja de Filmes, tendo a iniciativa de iniciar em um novo projeto de sua preferência. 

Então por isso que o Backlog do sistema foi criado por uma pessoa.
