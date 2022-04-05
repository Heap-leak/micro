# micro
The pet project based on Microservices Architecture: SpringBoot, Spring Cloud, Eureka, WebFlux, WebFluxSecurity, R2DBC (postgres) 

![Architecture](https://user-images.githubusercontent.com/1906125/161749570-f762087a-dd22-4c7e-8dbe-1832ae99e529.png)

#### Run project steps:

Build and run:
- mvn clean install
- docker-compose up -d --build

DB init:
- postgres container: # psql -U postgres -d postgres_db -f home/init.sql
