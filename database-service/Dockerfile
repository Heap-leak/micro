
#RUN psql -U postgres -d purgatory -f /home/purgatory_init.sql

FROM adoptopenjdk/openjdk14:alpine-jre
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]