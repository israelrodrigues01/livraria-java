 
# Loja de Filmes  

### 1. Descrição do sistema
O sistema desenvolvido consiste em um ambiente de venda e comercialização de filmes. Com o objetivo de facilitar a venda de seus produtos por lojas físicas e expandir seus negócios, tornando-os mais escaláveis. 
O programa possibilita o cadastro e login de novos usuários, onde será disponível um menu no qual pode buscar os filmes que deseja comprar ou acessar a lista completa de filmes. Além disso, ele poderá editar suas informações, por exemplo, sua conta, nome, senha e outros dados. Assim, o usuário tem total controle de seus dados e informações sobre os filmes a qual deseja comprar. 
O administrador faz o controle de todo o sistema, sendo ele responsável por adicionar filmes, atualizar e deletar. Outra funcionalidade será o controle de novos usuários e os já cadastrados no sistema. Podendo adicionar um novo Admin ou um usuário normal. E, como usuário também, poderá fazer todas ações que o usuário comum, como comprar filmes, ver as listas, etc.

### 2. Backlog
 
| Funcionalidade            | Responsável |
| ---                       | ---         |
| Classes e Atributos       | Israel      |
| CRUD Filme                | Ivna        |
| CRUD Usuário              | Israel      |
| Login e Cadastro          | Israel      |

### 3. Arquitetura do Sistema	
Link do diagrama completo: [Diagrama de Classes](https://drive.google.com/file/d/1_opVff3-dNzWFt0lbPhiZfwHVf4PdazW/view?usp=sharing)

Link do documento completo: [Documento](https://docs.google.com/document/d/1zWNy_OLfm_tBKB0inTQ-KMLUPbHrlXdD2ms_IvjqBVk/edit?usp=sharing)


O diagrama de classes acima descreve a estrutura que será seguida pelo sistema. O esquema contém as classes Filmes e Usuário, com os seus respectivos atributos e métodos. Atributos e Métodos para as classe Filmes e Usuarios.

Será adicionado, também, as classes de Repositorios, onde serão armazenadas informações sobre os filmes e usuários, como forma de banco de dados e toda a realização do CRUD.

Há classes com sufixo DAO, que seria a ligação entre as classes usuario e filmes, com as de repositorios, facilitando a integração das informações e verificações de possíveis erros. Elas servem para facilitar os dados enviados pelo o Usuário e a manipulação dos dados, tirando todo esse trabalho na view ou nos repositórios, deixando eles só para manipulação de adicionar, deletar, sem que não precise se preocupar com outras manipulações, deixando isso para as classes DAO.

Outras a subclasse, como a Admin que herda da classe Usuario, possuindo os mesmos atributos da classe Usuario, como o método addUser()  e a subclasse RepositorioMeusFilmes, onde herda de RepositorioFIlmes, mas tem métodos que diferenciam na manipulação dos dados.

Há ainda as classes Login, Menu e Verificacoes. Nos quais os métodos  servem como apoio e toda as verificações sobre o sistema completo. O Login ficará responsável pelo cadastro de usuário (cadastro feito na tela inicial do sistema), o acesso e informa se o usuário está logado ou não. Na classe Menu terá todas as views dos menus (ou tipo de links), informando ao usuário no console o fluxo a qual pode seguir no sistema. Já na classe Verificacoes, lá está a manipulações de controle do sistema, onde terá toda a base para que não tenha informações importantes iguais, por exemplo, email do usuário, nome de filme e senha a qual usuario se cadastrou. Facilitando para que o sistema não tenha falhas.

### 4. Teste do Sistema
No sistema haverá um teste principal na qual tem dois usuários cadastrados de início, para caso não queira cadastrar possa logar de primeira. Os usuários já adicionados são: usuário normal - teste@gmail.com e admin - admin@gmail.com. Ambas as contas têm a mesma senha: 123.

Para usar o sistema é simples, após logar em sua conta aparecerá o menu informando o fluxo no qual deseja seguir, por exemplo: Loja de filmes, seu perfil, editar seu perfil e deslogar da conta. De acordo com sua conta essas informações podem mudar, por exemplo, a conta Admin tem informações a mais, que são: CRUD Usuários, CRUD filmes. 

Na loja, os filmes disponíveis vão indicar quais filmes você pode comprar, mas caso esteja faça, o admin deverá adicionar filmes para que sejam comprados. Então, para testar a opção de compra de filmes e a loja no geral, logar na conta Admin fará mais sentido, onde adicionando os filmes fará com que o fluxo da loja seja disponível.
 