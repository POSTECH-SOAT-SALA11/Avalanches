# Use a imagem base do OpenJDK 21
FROM openjdk:21

# Copie o arquivo JAR da sua aplicação para o contêiner
COPY target/avalanches-0.0.1-SNAPSHOT.jar /app/avalanches-0.0.1-SNAPSHOT.jar

# Defina o diretório de trabalho no contêiner
WORKDIR /app

# Comando para executar a aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "avalanches-0.0.1-SNAPSHOT.jar"]
