FROM eclipse-temurin:23-jdk
WORKDIR /app

# Copy the executable JAR from the Web module
COPY target/Web-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]


