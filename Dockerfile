FROM adoptopenjdk/maven-openjdk11 AS build
WORKDIR app
COPY src src
COPY pom.xml .
RUN mvn clean package

FROM adoptopenjdk/openjdk11:alpine-jre
COPY --from=build app/target/notifications-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE ${PORT}
ENTRYPOINT ["sh", "-c", "java -Dserver.port=${PORT} -Dspring.kafka.bootstrap-servers=${BOOTSTRAP_SERVERS} -jar /app.jar"]