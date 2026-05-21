<<<<<<< HEAD
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY *.java .

RUN javac *.java

ENV JAVA_TOOL_OPTIONS="-Djava.awt.headless=true"

CMD ["java", "-Djava.awt.headless=true", "ECommerceSystem"]
=======
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
>>>>>>> e04ee9ea1f63d46a9c2025e7cfbbf160f3ad5dae
