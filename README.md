
Instruções de utilização
Essas instruções vão te levar a uma cópia do projeto rodando em sua máquina local.

Pré-requisitos:

Ter instalado todas as ferramentas e dependências abaixo:
Java
Maven
MySQL

Passo 1: Clonar o repositório:
$ git clone git@github.com:psantosi/livaria-api.git

Passo 2: Configurar e iniciar a API Spring Boot (backend)

Passo 2.1: Entrar no arquivo application.properties:
$ vi livaria-api\src\main\resources\application-dev.properties
Passo 2.2: Configurar as credenciais de banco de dados de acordo com sua instalação do MySQL Server:

Passo 2.3: Voltar para a pasta raíz do projeto:
$ cd livaria-api\
Passo 2.4: Iniciar a aplicação Spring Boot:
$ mvn clean install
Passo 2.4.1: Iniciar a aplicação Spring Boot utilizando o Maven:
$ mvn spring-boot:run

API estará rodando em http://localhost:8080/

Passo 3: Entrar na aplicação frontend após subir a API

Passo 3.1: Entrar na pasta raíz do projeto:
$ cd livaria-api\
Passo 3.2: Abrir o arquivo index.html diretamente:

Rotas disponíves na API:

Login
http://localhost:8080/login - Metodo POST - body: body: {username: String, passoword: String} - Logar;

Usuario
http://localhost:8080/usuario - Metodo POST - body: {username: String, passoword: String, perfil: int(1 - ADMIN, 2 - USUARIO)} - Criar usuário;
http://localhost:8080/usuario/{id} - Metodo PUT - body: {username: String, passoword: String} - Atualizar usuário;
http://localhost:8080/usuario/{id} - Metodo DELETE - Deletar usuário;

Filmes
http://localhost:8080/filme - Metodo GET (Autenticação token JWT) - Busca todos os filmes;
http://localhost:8080/filme/{id} - Metodo GET (Autenticação token JWT) - Busca um filme pelo id;
http://localhost:8080/filme - Metodo POST (Autenticação token JWT) - body: {titulo: String, diretor: String, genero: String, descricao: String} - Cadastra um filme;

Voto
http://localhost:8080/voto - Metodo POST (Autenticação token JWT) - body: {nota: int, idFilme: long} - Votar;



