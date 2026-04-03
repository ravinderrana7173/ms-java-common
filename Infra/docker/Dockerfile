# Build stage
FROM maven:3.8.4-openjdk-17-slim AS build

# Copy code
COPY . /build/

# Build app
RUN mvn -f /build/pom.xml clean package -DskipTests

# Package stage
FROM openjdk:17-jdk-slim

COPY --from=build /build/common-rest/target/common-rest-2.0.0.jar /app/common-rest-2.0.0.jar

WORKDIR /app

# Run app
ENTRYPOINT ["java","-jar","common-rest-2.0.0.jar"]
