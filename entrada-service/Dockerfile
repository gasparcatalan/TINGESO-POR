FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} entrada-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/entrada-service-0.0.1-SNAPSHOT.jar"]