FROM openjdk:23
WORKDIR /app
COPY target/homechat-0.0.1-SNAPSHOT.jar chat-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "chat-app.jar"]
