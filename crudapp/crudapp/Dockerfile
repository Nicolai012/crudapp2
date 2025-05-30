# Etapa 1: Build da aplicação com Maven + Java 21
FROM maven:3.9-eclipse-temurin-21 AS builder

# Define diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia os arquivos de configuração e código-fonte
COPY pom.xml .
COPY src ./src

# Compila e empacota a aplicação, ignorando os testes
RUN mvn clean package -DskipTests

# Etapa 2: Imagem final somente com o .jar gerado
FROM eclipse-temurin:21-jdk

# Define o diretório de trabalho no contêiner final
WORKDIR /app

# Copia o .jar da fase anterior para cá

COPY --from=builder /app/target/*.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
