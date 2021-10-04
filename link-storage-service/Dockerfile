FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=build/libs/link-storage-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
#this file needs more modifications so follow: https://spring.io/guides/gs/spring-boot-docker/
# Create a docker-compose so that we don't need to remember the complete run command
#Build it:    docker build -t armanavasthi/linkhub:link-storage-service-0.0.1 .
#Run it: docker run -p 6060:6060 armanavasthi/linkhub:link-storage-service-0.0.1