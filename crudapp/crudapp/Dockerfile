# Etapa 1: Build da aplicação com Maven + Java 21
FROM maven:3.9-eclipse-temurin-21 AS builder

WORKDIR /app

# Copia apenas o pom.xml e baixa as dependências para aproveitar o cache do Docker
COPY pom.xml .
RUN mvn dependency:go-offline

# Agora copia o restante do código
COPY src ./src

# Compila e empacota a aplicação, ignorando os testes
RUN mvn clean package -DskipTests

# Etapa 2: Imagem final somente com o .jar gerado
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copia o .jar da fase anterior para cá
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
