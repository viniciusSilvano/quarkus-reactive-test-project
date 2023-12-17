FROM alpine:3.19.0

RUN apk add openjdk11-jre

WORKDIR /app
COPY . .
WORKDIR /app/target/quarkus-app
EXPOSE 8080
CMD java -jar quarkus-run.jar
