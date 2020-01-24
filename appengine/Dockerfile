FROM openjdk:8-jdk-alpine
MAINTAINER Ostap <ostap1599@gmail.com>
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/retail-1.0-SNAPSHOT.jar
ADD ${JAR_FILE} retail.jar
ENTRYPOINT ["java","-jar","/retail.jar"]