#FROM openjdk:23
#
#WORKDIR /app
#
## Copy the executable JAR from the Web module
#COPY target/Web-0.0.1-SNAPSHOT.jar app.jar
#
#EXPOSE 8080
#
#ENTRYPOINT ["java", "-jar", "app.jar"]
FROM openjdk:23

WORKDIR /app

# Copy the project source code into the container
COPY . /app

# Run Maven to build the project, skipping tests
RUN mvn clean install -U -DskipTests

# Copy the built JAR from the Web module to the app directory
COPY target/Web-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
