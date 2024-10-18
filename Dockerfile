FROM maven:3.9.8-eclipse-temurin-21 AS build
WORKDIR /opt/app
COPY pom.xml .
# Download dependencies only (helps with caching)
RUN mvn dependency:go-offline

# Copy the rest of the source code
COPY . /opt/app
RUN mvn clean package

# Second stage
FROM eclipse-temurin:21-jre-alpine
WORKDIR /opt/app

# Ensure the build succeeded and the .jar file exists
COPY --from=build /opt/app/target/*.jar /opt/app/app.jar

ENV PROFILE=prd
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILE}", "-jar", "app.jar"]
