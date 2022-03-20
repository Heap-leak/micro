# micro
The pet project based on Microservices Architecture: SpringBoot, WebFlux, R2DBC 

#### Run project steps:

Build and run:
- mvn clean install
- docker-compose up -d --build

DB init:
- postgres container: # psql -U postgres -d postgres_db -f home/init.sql
