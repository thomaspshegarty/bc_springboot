FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=~/workspace/bc_springboot/target/lcstracker-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} ./lcstracker.jar
ENTRYPOINT ["java","-jar","/lcstracker.jar"]