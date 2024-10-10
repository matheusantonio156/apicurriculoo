# Use a imagem base do Java
FROM openjdk:11-jre-slim

# Crie um diretório para a aplicação
WORKDIR /app

# Copie o JAR para o contêiner
COPY api-curriculo/target/api-curriculo-0.0.1-SNAPSHOT.jar app.jar

# Execute o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
