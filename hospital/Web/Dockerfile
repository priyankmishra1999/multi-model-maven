# Use Maven image to build the project
FROM maven:3.9.9-eclipse-temurin-23 as builder

# Set working directory inside the container
WORKDIR /app

# Copy the entire project into the container
COPY . .

# Build the project using Maven
RUN mvn clean install -DskipTests

# Use a lightweight Java image for running the application
FROM eclipse-temurin:23-jre-alpine

# Set working directory inside the container
WORKDIR /app

# Copy the built jar file from the builder stage
COPY --from=builder /app/Web/target/*.jar app.jar

# Expose the port the application listens on (adjust according to your app)
EXPOSE 8080

# Define the entry point to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
