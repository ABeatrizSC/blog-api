# Blog API REST
Projeto API REST desenvolvida através do Curso de Java Completo, utilizando Spring Boot e o banco de dados MongoDB.

## Objetivos gerais
O projeto teve como foco aprender e revisar os seguintes tópicos:

- Compreender as principais diferenças entre paradigma orientado a documentos e relacional
- Implementar operações de CRUD
- Refletir sobre decisões de design para um banco de dados orientado a documentos
- Implementar associações entre objetos
  - Objetos aninhados
  - Referências
- Realizar consultas com Spring Data e MongoRepository

## Tecnologias utilizadas
Para o desenvolvimento desta atividade, foram utilizadas as seguintes tecnologias:
- Git
- Java 17
- Spring Boot v3.3.3
- Apache Maven
- MongoDB v7.0.14
- MongoDB Compass v1.44.3
- Postman

**IDE utilizada: IntelliJ IDEA Community Edition 2024.2**

## Uso de Query Methods e consultas com @Query
Durante o projeto, pude aprender duas formas de realizar consultas com Query. Elas estão presentes em `PostRepository`:
### Query Methods
Os Query Methods são um recurso do Spring Data que permite criar consultas automaticamente com base no nome do método.

```java
List<Post> findByTitleContainingIgnoreCase(String text);
````

### Consultas com @Query
Outra abordagem é o uso da anotação @Query, que permite a escrita de consultas personalizadas diretamente em Java. No exemplo abaixo, o método searchTitle utiliza uma consulta MongoDB para buscar posts cujo título corresponde a um regex (expressão regular), permitindo mais flexibilidade.

```java
@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
List<Post> searchTitle(String text);
````

## Funcionalidades/Endpoints
Para testar os seguintes endpoints, recomendo o uso do Postman, uma das ferramentas mais populares para testar e consumir APIs REST.
### 1. **Listar Todos os Usuários**
- **Endpoint:** `GET /users`
- Retorna uma lista de todos os usuários cadastrados no sistema.

### 2. **Buscar Usuário por ID**
- **Endpoint:** `GET /users/{id}`
- Busca e retorna as informações de um usuário com base no seu ID.

### 3. **Inserir um Novo Usuário**
- **Endpoint:** `POST /users`
- Insere um novo usuário no banco de dados.
- **Requisição:**
  ```json
  {
    "name": "Nome do Usuário",
    "email": "email@example.com"
  }
  ```

### 4. **Atualizar um Usuário**
- **Endpoint:** `PUT /users/{id}`
- Atualiza as informações de um usuário existente com base no seu ID.
- **Requisição:**
  ```json
  {
    "name": "Nome Atualizado",
    "email": "email_atualizado@example.com"
  }
  ```

### 5. **Excluir um Usuário por ID**
- **Endpoint:** `DELETE /users/{id}`
- Remove um usuário do sistema com base no seu ID.

### 6. **Listar Posts de um Usuário**
- **Endpoint:** `GET /users/{id}/posts`
- Retorna uma lista de todos os posts associados a um usuário específico.

---

### 7. **Buscar Post por ID**
- **Endpoint:** `GET /posts/{id}`
- Retorna um post específico com base no seu ID.

### 8. **Buscar Posts por Título**
- **Endpoint:** `GET /posts/titlesearch?text={title}`
- Retorna uma lista de posts cujo título contém o texto fornecido como parâmetro.


## Requisitos
Certifique-se de ter as seguintes ferramentas instaladas e configuradas:
- Java Development Kit (JDK) 11 ou superior
- Apache Maven
- MongoDB
- MongoDB Compass

## Instalação do Projeto
Siga os passos abaixo para baixar, configurar e rodar o projeto no seu ambiente
1. **Clone o repositório**
```bash
git clone https://github.com/abeatrizsc/blog-api.git
 ```
```bash
cd blog-api
 ```

2. **Compile o projeto e baixe as dependências**

 ```bash
mvn clean compile
 ```
 ```bash
mvn package
 ```

3. **Execute o projeto**

 ```bash
java -jar target/blog-API-0.0.1-SNAPSHOT.jar
 ```

**OBS: Este projeto está configurado para rodar na porta padrão localhost:8080. Certifique-se de que ela esteja disponível ou mude-o para outra porta adicionando no arquivo `application.properties` o comando `server.port=${port:8081}`.**

## Execução do Banco de Dados (MongoDB)
Com o MongoDB já instalado, execute-o em seu terminal com o seguinte comando:
 ```bash
 mongod
 ```
Certifique-se também de criar um banco de dados no MongoDB Compass chamado `workshop_mongo` e as collections `Post` e `User`. 

## Contato
Para dúvidas ou problemas, entre em contato em:
* Email: anabeatrizscarmoni@gmail.com
* GitHub: github.com/ABeatrizSC
