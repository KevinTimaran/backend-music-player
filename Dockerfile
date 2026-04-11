FROM eclipse-temurin:21-jdk AS builder
WORKDIR /app

COPY music-player-backend/.mvn/ .mvn/
COPY music-player-backend/mvnw music-player-backend/pom.xml ./
COPY music-player-backend/src/ src/

RUN chmod +x mvnw && ./mvnw -DskipTests package

FROM eclipse-temurin:21-jre
WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 10000
ENV PORT=10000

ENTRYPOINT ["java", "-jar", "/app/app.jar"]

