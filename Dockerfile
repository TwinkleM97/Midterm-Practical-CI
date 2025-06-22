FROM amazoncorretto:17-alpine

WORKDIR /app

COPY target/task-manager-1.0.0.jar app.jar

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java -jar app.jar"]
