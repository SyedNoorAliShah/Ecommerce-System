FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY *.java .

RUN javac *.java

ENV JAVA_TOOL_OPTIONS="-Djava.awt.headless=true"

CMD ["java", "-Djava.awt.headless=true", "ECommerceSystem"]