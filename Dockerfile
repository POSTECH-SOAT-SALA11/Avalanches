# Use uma imagem base do Maven 3.8.4 com JDK 21
FROM maven:3.8.7-openjdk-18-slim AS build

# Defina o diretório de trabalho no contêiner
WORKDIR /app

# Copie o arquivo pom.xml e as dependências do projeto
COPY pom.xml .

# Baixe as dependências do projeto
RUN mvn dependency:go-offline -B

# Copie o código-fonte do projeto para o contêiner
COPY src ./src

# Compile o projeto
RUN mvn clean install -DskipTests

# Use uma imagem mais leve do OpenJDK para executar a aplicação
FROM openjdk:18-jdk-slim

# Defina o diretório de trabalho no contêiner
WORKDIR /app

# Copie o JAR compilado da imagem de build para a imagem final
COPY --from=build /app/target/avalanches-0.0.1-SNAPSHOT.jar /app/avalanches-0.0.1-SNAPSHOT.jar

# Comando para executar a aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "avalanches-0.0.1-SNAPSHOT.jar"]
