# ---------------- BUILD STAGE ----------------
FROM maven:3.8.4-openjdk-17-slim AS build

WORKDIR /build
COPY . .

RUN apt-get update && apt-get install -y curl

# Build application
RUN mvn clean package -DskipTests

# ---------------- RUNTIME STAGE ----------------
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY --from=build /build/common-rest/target/common-rest-2.0.0.jar app.jar
COPY Infra/etcd/etc/confd /etc/confd

# Install confd
RUN apt-get update && apt-get install -y curl && \
    curl -L https://github.com/kelseyhightower/confd/releases/download/v0.16.0/confd-0.16.0-linux-amd64 \
    -o /usr/local/bin/confd && chmod +x /usr/local/bin/confd

# Create user
RUN groupadd -r javauser && useradd -r -g javauser javauser
RUN chown -R javauser:javauser /app

USER javauser

# Run confd at container start, not build time
ENTRYPOINT sh -c "\
  confd -confdir /etc/confd -onetime -backend vault \
  -node $VAULT_ADDR \
  -auth-type token \
  -auth-token $VAULT_TOKEN && \
  java -jar app.jar"
