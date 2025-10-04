# Estágio de Build: Compila a aplicação com o Maven
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Estágio de Execução: Roda a aplicação em um ambiente leve
FROM openjdk:17-slim-bullseye
WORKDIR /app
COPY --from=build /app/target/gerenciador-autores-obras-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
