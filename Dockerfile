FROM openjdk:17-jdk-slim
COPY target/movies-0.0.1-SNAPSHOT.jar /app.jar
CMD ["java", "-jar", "/app.jar"]