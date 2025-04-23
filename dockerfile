# Stage 1: Build
FROM eclipse-temurin:21-jdk AS builder

# Configurar diretório de trabalho
WORKDIR /app

# Copiar os arquivos do Gradle
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# Criar arquivo gradle.properties com as configurações do Quarkus
RUN echo "quarkusPluginId=io.quarkus" >> gradle.properties && \
    echo "quarkusPluginVersion=3.7.1" >> gradle.properties && \
    echo "quarkusPlatformGroupId=io.quarkus.platform" >> gradle.properties && \
    echo "quarkusPlatformArtifactId=quarkus-bom" >> gradle.properties && \
    echo "quarkusPlatformVersion=3.7.1" >> gradle.properties

# Copiar o código fonte
COPY src src

# Dar permissão de execução ao gradlew
RUN chmod +x ./gradlew

# Construir o projeto
RUN ./gradlew build -x test

# Stage 2: Runtime
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Copiar o arquivo JAR construído da etapa anterior
COPY --from=builder /app/build/quarkus-app/quarkus-run.jar ./app.jar

# Expor a porta que a aplicação usa
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
