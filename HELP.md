# Read Me First
The following was discovered as part of building this project:

* The original package name 'br.com.rsdconsultoria.lab-springboot' is invalid and this project uses 'br.com.rsdconsultoria.labspringboot' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.0/maven-plugin/reference/html/#build-image)
* [Jersey](https://docs.spring.io/spring-boot/docs/2.7.0/reference/htmlsingle/#web.servlet.jersey)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.0/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.7.0/reference/htmlsingle/#actuator)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)


# Banco de Dados in memmory

## Para acessar as tabelas

Mudar no application.properties:
```
spring.h2.console.enabled=true
```

Acessar no browser:
```
http://localhost:8080/h2-console/login.do
```


