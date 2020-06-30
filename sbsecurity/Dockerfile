FROM java:8-jdk-alpine
COPY ./target/sbsecurity-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "sbsecurity-0.0.1-SNAPSHOT.jar"]