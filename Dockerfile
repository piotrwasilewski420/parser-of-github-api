FROM openjdk:17-jdk-slim-buster
EXPOSE 8080
ARG JAR_FILE=target/allegro-summer-experience-2022-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]