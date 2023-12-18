FROM alpine:3.19.0

RUN apk add openjdk11-jre

WORKDIR /app

COPY target/quarkus-app/lib/ /deployments/lib/
COPY target/quarkus-app/*.jar /deployments/
COPY target/quarkus-app/app/ /deployments/app/
COPY target/quarkus-app/quarkus/ /deployments/quarkus/

WORKDIR /app/target/quarkus-app
EXPOSE 8080
CMD java -jar quarkus-run.jar
