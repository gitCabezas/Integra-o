# 📚 API CRUD - Obras e Autores

API desenvolvida para gerenciar **autores** e suas respectivas **obras**.  
Com uma estrutura RESTful, oferece endpoints para criar, listar, atualizar e deletar informações relacionadas, de forma prática e organizada.

## 👨‍💻 Equipe

- **Pedro Ivo** — 2427862  
- **Rafael Lemos** — 2325363  
- **Rodrigo Cabezas** — 2426037  
- **Lucas Rodrigues da Silva** — 232265  

---

## 📌 Sumário

1. [Visão Geral](#-visão-geral)  
   1.1. [Introdução e Objetivo](#-introdução-e-objetivo)  
   1.2. [Tecnologias Utilizadas](#-tecnologias-utilizadas)  
   1.3. [Arquitetura](#-arquitetura)  
2. [Metodologia de Desenvolvimento](#-metodologia-de-desenvolvimento)  
   2.1. [Fluxo de uma Requisição](#-fluxo-de-uma-requisição)  
   2.2. [Endpoints](#-endpoints)  
   2.3. [Passos para Execução](#-passos-para-execução)  
3. [Artefatos do Produto](#-artefatos-do-produto)  
   3.1. [Swagger](#-swagger)  
   3.2. [GitHub](#-github)  

---

## 📝 Visão Geral

### 📌 Introdução e Objetivo
A API foi criada para permitir o **cadastro e gerenciamento de autores e obras**, oferecendo operações CRUD completas para ambas as entidades.

### 🧰 Tecnologias Utilizadas

- Java  
- Spring Boot  
- Spring Data JPA  
- Swagger  
- Spring Actuator  
- Banco de dados H2  
- IntelliJ IDEA  
- Git / GitHub

---

### 🏗 Arquitetura

A aplicação segue o padrão **MVC** e está organizada em três camadas principais:

- **Controller:** recebe as requisições HTTP, processa e retorna as respostas.  
  - `AutorController` e `ObraController`
- **Service:** implementa a lógica de negócio, preparando e manipulando os dados.
- **Repository:** realiza as operações no banco de dados utilizando JPA (CRUD completo).

#### Entidades
- **Autor**  
- **Obra**  
Cada entidade representa uma tabela no banco de dados H2.

---

## 🧭 Metodologia de Desenvolvimento

### 📤 Fluxo de uma Requisição

1. O cliente envia uma requisição HTTP (ex: POST para criar uma obra).  
2. O Controller recebe e chama o Service.  
3. O Service interage com o Repository para acessar o banco.  
4. A resposta é retornada ao cliente.

---

### 🌐 Endpoints

#### 📌 Autores

- **Criar Autor**  
  `POST /api/autores`  
  ```json
  {
    "nome": "Nome",
    "sexo": "Sexo",
    "email": "email@example.com",
    "dataNascimento": "AAAA-MM-DD",
    "paisOrigem": "País de origem",
    "cpf": "12345678900"
  }
  ```
  - **201**: Criado com sucesso  
  - **400**: Dados inválidos

---

- **Consultar Autor por ID**  
  `GET /api/autores/{id}`  
  - **200**: Retorna autor  
  - **404**: Não encontrado

---

- **Atualizar Autor**  
  `PUT /api/autores/{id}`  
  ```json
  {
    "nome": "Nome atualizado",
    "sexo": "Sexo Atualizado",
    "email": "email@atualizado.com",
    "dataNascimento": "AAAA-MM-DD",
    "paisOrigem": "País atualizado",
    "cpf": "12345678902"
  }
  ```
  - **200**: Atualizado  
  - **404**: Não encontrado

---

- **Excluir Autor**  
  `DELETE /api/autores/{id}`  
  - **204**: Excluído com sucesso  
  - **404**: Não encontrado

---

#### 📌 Obras

- **Criar Obra**  
  `POST /api/obras`  
  ```json
  {
    "nome": "nome obra",
    "descricao": "descricao obra",
    "dataPublicacao": "2024-11-14",
    "dataExposicao": "2024-11-14"
  }
  ```
  - **201**: Criada com sucesso  
  - **400**: Dados inválidos

---

- **Consultar Obra por ID**  
  `GET /api/obras/{id}`  
  - **200**: Retorna obra  
  - **404**: Não encontrada

---

- **Atualizar Obra**  
  `PUT /api/obras/{id}`  
  ```json
  {
    "nome": "nome obra atualizada",
    "descricao": "descricao obra atualizada",
    "dataPublicacao": "2024-11-14",
    "dataExposicao": "2024-11-14"
  }
  ```
  - **200**: Atualizada  
  - **404**: Não encontrada

---

- **Excluir Obra**  
  `DELETE /api/obras/{id}`  
  - **204**: Excluída com sucesso  
  - **404**: Não encontrada

---

## 🧪 Testes Unitários

Foram implementados testes para validar regras de negócio, como restrições de unicidade (ex: `cpf`), garantindo que não sejam cadastrados dados duplicados.

Exemplo de log de erro de teste:
```
Unique index or primary key violation:
PUBLIC.UK3YWC2YKU3ANQTRSXVKY770K3_INDEX_3 ON PUBLIC.AUTOR(CPF NULLS FIRST)
```

---

## 📊 Swagger

A documentação dos endpoints pode ser acessada via **Swagger UI**, permitindo testes interativos da API.

---

## 🗃 Banco de Dados

Foi utilizado o **H2 Database**, que não requer configuração externa.  
Ideal para testes e desenvolvimento local.

---

## 🌐 GitHub

O versionamento do projeto foi feito via Git e hospedado no GitHub:  
👉 [https://github.com/gitCabezas/Integra-o](https://github.com/gitCabezas/Integra-o)

---

## 📅 Fortaleza — 2025