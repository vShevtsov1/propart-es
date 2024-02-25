FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/propart-es-0.0.1-SNAPSHOT.jar /app/propart-es.jar

EXPOSE 8080

CMD ["java", "-jar", "my-spring-boot-app.jar"]
