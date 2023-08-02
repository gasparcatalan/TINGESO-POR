FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} salida-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/salida-service-0.0.1-SNAPSHOT.jar"]