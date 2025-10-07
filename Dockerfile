FROM eclipse-temurin:17-jdk-focal as builder

# Define o diretório de trabalho.
WORKDIR /app

# Copia os arquivos de configuração do Maven.
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Baixa as dependências. Esta camada será cacheada pelo Docker, acelerando builds futuros.
RUN ./mvnw dependency:go-offline

# Copia o código-fonte do projeto.
COPY src ./src

# Compila o projeto e gera o arquivo .jar, pulando os testes para acelerar o processo.
RUN ./mvnw package -DskipTests



# Usa uma imagem Java Runtime (JRE), que é muito menor e mais segura para produção.
FROM eclipse-temurin:17-jre-focal

# diretório 
WORKDIR /app

#  parâmetro da JVM 
ENV JAVA_OPTS="-XX:-UseContainerSupport"

# Copia o arquivo .jar
COPY --from=builder /app/target/gerenciador-autores-obras-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta 8080
EXPOSE 8080

# iniciar a aplicação 
ENTRYPOINT ["java", "-jar", "app.jar"]
