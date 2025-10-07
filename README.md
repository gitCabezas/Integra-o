API CRUD OBRAS/AUTORES
Equipe:
Pedro Ivo: 2427862
Rafael Lemos: 2325363
Rodrigo Cabezas: 2426037
Lucas Rodrigues da Silva: 232265
FORTALEZA
2025
SUMÁRIO
Conteúdo
1. VISÃO GERAL
1.1. Introdução e Objetivo 3
1.2. Tecnologias Utilizadas 3
1.3. Arquitetura 4
2. METODOLOGIA PARA O DESENVOLVIMENTO DE SOFTWARE
2.1. Fluxo de uma Requisição 5
2.2. Endpoints 5
2.3. Passos para a Execução 5
3. ARTEFATOS DO PRODUTO
3.1. Swagger 9
3.2. Github 11
2
API CADASTRO OBRAS E AUTORES
A API foi desenvolvida com intenção de gerenciar autores e suas respectivas obras. Ela
permite que o cliente registre, liste, edite e delete informações sobre autores e obras.
Com uma estrutura RESTful, a API oferece um conjunto de endpoints que possibilitam
operações para o controle desses dados.
Tecnologias Utilizadas
Para realização desse desafio foram utilizadas as seguintes tecnologias:
●
●
●
●
●
●
●
●
●
Java
Spring Boot
Sprind Data JPA
Swagger
Spring Actuator
Banco de dados H2
IntelliJ
Git
GitHub
3
Arquitetura
A aplicação é construída com uma arquitetura em camadas, seguindo o padrão
MVC, e conta com as seguintes camadas:
●
●
●
Controller: Reponsável por receber as requisições HTTP dos clientes,
processa-las e retornar as respostas adequadas. Cada endpoint da
API é definido nessa camada.
AutorController e ObraController.
Service: Implementa a lógica de negócio da aplicação. Nessa camada,
são realizadas as operações necessárias e preparação das informações
para serem salvas ou recuperadas do banco de dados.
Repository: Faz a comunicação com o banco de dados,
executando operações de CRUD (Create, Read, Update, Delete)
por meio de uma interface com o JPA.
Entidades
Foram utilizadas duas Entidades “Autor” e “Obra”, que são os objetos a serem
manipuladas no banco de dados. Essas entidades são mapeadas para tabelas
do banco de dados, e cada instância de uma entidade corresponde a uma
linha
nessa tabela.
4
Fluxo de uma requisição
1. O cliente faz uma requisição HTTP para o controlador (por
exemplo, um POST para criar uma nova obra).
2. O controlador recebe essa requisição e chama o serviço para
processar a lógica necessária.
3. O serviço pode interagir com o repositório para salvar, atualizar ou
buscar dados no banco de dados.
4. O serviço retorna os dados ou resultados para o controlador, que
então os envia de volta para o cliente.
Endpoints
A API oferece um conjunto de endpoints para o gerenciamento de autores e
obras, permitindo operações de criação, leitura, atualização e exclusão.
Autores
1. Criar Autor
●
URL: /api/autores
●
Método: POST
●
Descrição: Cria um novo autor no sistema.
●
Corpo da requisição:
{
"nome": "Nome",
"sexo": "Sexo",
"email": "email@example.com",
"dataNascimento": "AAAA-MM-DD",
"paisOrigem": "País de origem",
"cpf": "12345678900"
}
●
●
Respostas:
201 Created: Autor criado com sucesso.
400 Bad Request: Dados de entrada inválidos.
2. Consultar Autor por ID
●
URL: /api/autores/{id}
●
Método: GET
●
Descrição: Retorna os detalhes de um autor específico.
●
Parâmetros:
5
●
●
Id : ID do autor a ser
consultado. Respostas:
200 OK: Detalhes do autor.
404 Not Found: Autor não encontrado.
3. Atualizar Autor
●
URL: /api/autores/{id}
●
Método: PUT
●
Descrição: Atualiza as informações de um autor existente.
●
Parâmetros:
o Id: ID do autor a ser removido.
●
Corpo da Requisição:
{
"nome": "Nome atualizado",
"sexo": "Sexo Atualizado",
"email": "email@atualizado.com",
"dataNascimento": "AAAA-MM-DD",
"paisOrigem": "País atualizado",
"cpf": "12345678902"
}
●
●
200 OK: Detalhes do autor.
404 Not Found: Autor não encontrado
4. Excluir Autor
●
URL: /api/autores/{id}
●
Método: DELETE
●
Descrição: Remove um autor do Sistema.
●
Parâmetros:
Id: ID do autor a ser removido.
●
204 No Content: Autor excluído com sucesso.
●
404 Not Found: Autor não encontrado.
6
OBRAS
1. Criar Obra
●
URL: /api/obras
●
Método: POST
●
Descrição: Cria um nova obra associada a um autor.
●
Corpo da requisição:
{
"nome": "nome obra",
"descricao": "descricao obra",
"dataPublicacao": "2024-11-14",
"dataExposicao": "2024-11-14"
}
●
●
Respostas:
201 Created: Autor criado com sucesso.
400 Bad Request: Dados de entrada inválidos.
5. Consultar Obra por ID
●
URL: /api/obras/{id}
●
Método: GET
●
Descrição: Retorna os detalhes de uma obra específica.
●
Parâmetros:
Id : ID da obra a ser consultada.
Respostas:
●
200 OK: Detalhes da obra.
●
404 Not Found: Obra não encontrado.
6. Atualizar Obra
●
URL: /api/obras/{id}
●
Método: PUT
●
Descrição: Atualiza as informações de uma obra existente.
●
Parâmetros:
o Id: ID da obra a ser removido.
●
Corpo da Requisição:
{
"nome": "nome obra atualizada",
"descricao": "descricao obra atualizada",
"dataPublicacao": "2024-11-14",
"dataExposicao": "2024-11-14"
}
7
●
●
200 OK: Detalhes da obra.
404 Not Found: Obra não encontrado
7. Excluir obra
●
URL: /api/obras/{id}
●
Método: DELETE
●
Descrição: Remove um autor do Sistema.
●
Parâmetros:
Id: ID da obra a ser removido.
●
204 No Content: Obra excluída com sucesso.
●
404 Not Found: Obra não encontrada.
8
Swagger:
9
Status Actuator:
Banco de Dados: Visão do Banco de dados H2
Foi utilizado o banco H2, pois não exige configuração de um banco externo.
Teste unitário:
No exemplo, o teste visa não permitir cadastro de informações com a
anotação @Unique, para que não seja possível ter dados únicos duplicados
no banco de dados, como por exemplo “cpf”:
10
(...)2024-11-14T15:49:00.386-03:00 ERROR 9868 --- [gerenciador-autores-obras] [ main]
o.h.engine.jdbc.spi.SqlExceptionHelper : Unique index or primary key violation:
"PUBLIC.UK3YWC2YKU3ANQTRSXVKY770K3
INDEX
_
_
3 ON PUBLIC.AUTOR(CPF NULLS FIRST) VALUES ( /* 1 */
'123.456.789-
02' )"; SQL statement:
insert into autor (cpf,data
_
nascimento,email,nome,pais
_
origem,sexo,id) values (?,?,?,?,?,?,default) [23505-224](..)
Parte do log do teste que valida a intenção do teste:
Git Hub
Foi utilizado o Git Hub para versionamento do código:
Link GitHub
11