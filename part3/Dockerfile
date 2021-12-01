FROM openjdk:11

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ENV SERVER_PORT=8081

EXPOSE $SERVER_PORT
ENTRYPOINT ["java","-jar","-Dserver.port=${SERVER_PORT}","/app.jar"]