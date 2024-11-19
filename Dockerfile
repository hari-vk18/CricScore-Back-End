# Use Maven image to build the project
FROM maven:3.8.7-openjdk-21-slim AS build

WORKDIR /app

# Copy the project files
COPY . .

# Run Maven to build the project
RUN ./mvnw clean package -DskipTests

# Use OpenJDK image to run the app
FROM openjdk:21-jdk-slim

WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/CricScore-0.0.1-SNAPSHOT.jar app.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]