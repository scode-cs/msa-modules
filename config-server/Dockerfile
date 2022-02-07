FROM openjdk:17
EXPOSE 8888
ADD target/config-server-*.jar config-server.jar
ENTRYPOINT ["java", "-jar", "--enable-preview", "/config-server.jar"]