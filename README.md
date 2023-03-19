# Link shortener
A simple web application that supports the following features:
* Create and read shortened link
* Redirect to specific page by short link identifier
* Handle business exception like: LinkNotFound, LinkAlreadyExists
* Application automatically delete expired links within specified period
- --
## Technologies
* Java 17
* Maven
* Spring Boot
* Hibernate
* H2
* Lombok

## Usage
```
git clone https://github.com/mateusz-konczal/link-shortener.git
cd link-shortener
mvn spring-boot:run
```

* You can access application on [localhost:8080](http://localhost:8080)
* REST API documentation is available on [localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/)

## Demo
![screenshot](https://github.com/mateusz-konczal/link-shortener/blob/main/img/img.png?raw=true)
