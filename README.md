# spring-boot-forum

Projeto API REST de Forum implementado em Java com Spring Boot. 

Funcionalidades implementadas neste projeto:

- Cadastro, pesquisa, consulta, atualização e exclusão (CRUD) de um Tópico;
- Validação de cadastro utilizando Bean Validation;
- Persistência de dados utilizando Spring Data JPA com Hibernate;
- Paginação e ordenação;
- Utilizando Cache para armazenar informações em memória;

## Dependências:

|dependency|groupId|artifactId|scope|
|---|---|---|---|
| Web | org.springframework.boot|spring-boot-starter-web |-|
| JPA | org.springframework.boot | spring-boot-starter-data-jpa | - |
| devtools | org.springframework.boot | spring-boot-devtools | runtime |
| Bean Validation | org.springframework.boot | spring-boot-starter-validation | - |
| Cache | org.springframework.boot | spring-boot-starter-cache | - |
| H2 | com.h2database | h2 | - |

## Pontos interessantes para estudo

- Lambdas
- Stream

