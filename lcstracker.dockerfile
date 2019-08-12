FROM openjdk:8
VOLUME /tmp
ARG JAR_FILE=./target/lcs-tracker-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} ./lcstracker.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","./lcstracker.jar"]