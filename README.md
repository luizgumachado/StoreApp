# StoreApp - API de Gerenciamento de Produtos Multimídia

Este projeto é uma API REST desenvolvida em Java com Spring Boot para gerenciar um catálogo de produtos (Livros, CDs e Blu-Rays). A aplicação foca na implementação de padrões de projeto (Design Patterns) e conceitos sólidos de Programação Orientada a Objetos (POO).

## 🚀 Tecnologias Utilizadas

* **Java 17+**
* **Spring Boot 3**
* **Spring Data JPA**: Persistência de dados e herança (Estratégia JOINED).
* **H2 Database**: Banco de dados em memória para desenvolvimento.
* **SpringDoc OpenAPI (Swagger)**: Documentação interativa da API.
* **Lombok**: Redução de código boilerplate.
* **Maven**: Gerenciamento de dependências.

## 🏛️ Arquitetura e Padrões de Projeto

A aplicação segue uma arquitetura em camadas (Controller -> Service -> Repository) e aplica os seguintes padrões:

### 1. Data Transfer Object (DTO)
Utilizado para desacoplar a camada de persistência (Entidades) da camada de exibição (API), garantindo segurança e flexibilidade no tráfego de dados.

### 2. Mapper Pattern
Implementação manual de Mappers para converter Entidades em DTOs e vice-versa. Isso centraliza a lógica de transformação e mantém os Services limpos.

### 3. Herança e Polimorfismo
* **Classe Abstrata `Product`**: Define o contrato e os atributos comuns, impedindo a criação de produtos genéricos.
* **Polimorfismo de Conversão**: O método `convertToDto` utiliza `instanceof` para processar qualquer tipo de produto de forma genérica.

## 🛠️ Detalhes de Implementação

### Tratamento de Erros
A API utiliza blocos `try-catch` nos Controllers para capturar exceções lançadas pela camada de serviço, retornando status HTTP apropriados como `404 Not Found` para IDs inexistentes ou `400 Bad Request` para falhas de validação.

### Persistência com Herança
Utilizamos a estratégia `@Inheritance(strategy = InheritanceType.JOINED)`, que cria tabelas separadas para cada subclasse, mantendo a integridade referencial no banco de dados.

## 🔧 Como Rodar o Projeto Localmente

1.  **Pré-requisitos**: Java 17 e Maven instalados.
2.  **Clone o repositório**:
    ```bash
    git clone [https://github.com/luizgumachado/StoreApp.git](https://github.com/luizgumachado/StoreApp.git)
    ```
3.  **Execute a aplicação**:
    ```bash
    mvn spring-boot:run
    ```
4.  **Acesse a Documentação (Swagger)**:
    Abra o navegador em: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
5.  **Console do Banco de Dados (H2)**:
    Acesse: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
    * **JDBC URL**: `jdbc:h2:mem:lojadb`
    * **User**: `sa`
    * **Password**: (vazio)

## 📡 Endpoints Principais

* `GET /api/products`: Lista todos os produtos (Polimórfico).
* `POST /api/books`: Cadastra um novo livro.
* `PUT /api/books/{id}`: Atualiza um livro existente.
* `DELETE /api/books/{id}`: Remove um livro.
