FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=build/libs/ui-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
#this file needs more modifications so follow: https://spring.io/guides/gs/spring-boot-docker/
# Create a docker-compose so that we don't need to remember the complete run command
#Build it (first do `gradle clean build` then):    docker build -t armanavasthi/linkhub:ui-service-0.0.1 .
#Run it: docker run -p 80:80 armanavasthi/linkhub:ui-service-0.0.1
# to run on linux (as in EC2), you should use:
# docker run -p 80:80 --add-host host.docker.internal:host-gateway armanavasthi/linkhub:ui-service-0.0.2
# reason: in mac, host.docker.internal is directly acccessible but in linux we have to add-host (https://stackoverflow.com/a/24326540/7456022)
#Push to docker hub (use `docker login` first if you are not logged in ever on the machine as its a private repo)
#docker push armanavasthi/linkhub:ui-service-0.0.1