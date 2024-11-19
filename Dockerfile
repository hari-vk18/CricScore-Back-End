# Use an OpenJDK base image
FROM openjdk:21-jdk-slim

# Update apt and install Maven
RUN apt-get update && apt-get install -y maven

# Set the working directory
WORKDIR /app

# Copy the project files into the container
COPY . .

# Run Maven to build the project
RUN mvn clean package -DskipTests

# Define the entry point
ENTRYPOINT ["java", "-jar", "target/your-app.jar"]
