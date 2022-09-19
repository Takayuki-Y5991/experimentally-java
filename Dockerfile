# Building Application
FROM gradle:7.2.0-jdk17-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon -x test

# Build Docker image
FROM openjdk:17-jdk-alpine
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/app.jar /app/app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=prod" ,"-jar", "/app/app.jar"]