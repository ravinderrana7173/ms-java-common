#Build stage
FROM maven:3.8.4-openjdk-17-slim AS build
# Add code to docker
COPY . /build/
RUN mkdir /build/cert
RUN apt-get -y update && \
    apt-get install -y curl iputils-ping vim 
#Install confd
RUN curl -s -L https://github.com/kelseyhightower/confd/releases/download/v0.16.0/confd-0.16.0-linux-amd64 -o /usr/local/bin/confd && chmod +x /usr/local/bin/confd
RUN /usr/local/bin/confd -confdir /build/Infra/etcd/etc/confd -onetime -backend vault -node VAULT_ADDR -client-ca-keys /build/Infra/vault-cert/client-cert.pem -client-cert /build/Infra/vault-cert/cert.pem  -client-key /build/Infra/vault-cert/key.pem -auth-type token -auth-token VAULT_TOKEN
RUN openssl pkcs12 -export -out /build/cert/cc.pfx -inkey /build/cert/key.pem -in /build/cert/cert.pem -passout pass:p0lo9ki8
#Build the code
#RUN cat /build/common-rest/src/main/resources/application.properties
RUN  --mount=type=cache,mode=0777,target=/root/.m2,rw mvn  -f /build/pom.xml clean package

#RUN ls -l /build
#RUN ls -l /build/target/
#Package stage
FROM openjdk:17-ea-jdk-buster
#FROM openjdk:8u332-jdk-bullseye
COPY --from=build /build/common-rest/target/common-rest-2.0.0.jar app/common-rest-2.0.0.jar
COPY --from=build /build/cert /app/cert
#Add user
RUN groupadd -r javauser && useradd -g javauser javauser
WORKDIR /app
RUN ls -la
RUN chown -R javauser:javauser /app
#USER javauser
#Run the jar
ENTRYPOINT ["java","-jar", "common-rest-2.0.0.jar"]

