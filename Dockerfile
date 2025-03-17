FROM openjdk:23
WORKDIR /app
COPY target/homechat-0.0.1-SNAPSHOT.jar chat-app.jar
EXPOSE 8080
EXPOSE 8000
ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8000", "-Dspring.profiles.active=localdocker", "-jar", "chat-app.jar"]
