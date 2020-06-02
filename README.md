# spring-boot-forum
Projeto de forum baseado no framework Spring Boot para desenvolvimento de uma API Rest. 

## Pontos interessantes para estudo

- Lambdas
- Stream

## Bean Validation

Para validação dos atributos enviados no corpo das requisições.

### Dependência no POM do projeto

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

@Valid (javax.validation.Valid): Indica para o Spring que devem ser executadas validações do Bean Validation no parâmetro do método.
