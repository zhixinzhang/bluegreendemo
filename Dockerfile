# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-jammy as base
EXPOSE 8080
EXPOSE 80
ADD target/blizzardbluegreendemo.jar blizzardbluegreendemo.jar
ENTRYPOINT [ "java", "-jar", "/blizzardbluegreendemo.jar" ]
# WORKDIR /app
# COPY . .
