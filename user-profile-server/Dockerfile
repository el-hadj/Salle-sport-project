FROM openjdk:17
EXPOSE 8081
ADD target/user-profile-server-0.0.1-SNAPSHOT.jar user-profile-server.jar
ENTRYPOINT ["java", "-jar", "/user-profile-server.jar"]