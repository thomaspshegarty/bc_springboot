# LCS Tracker

by Thomas Hegarty
for MS3 Bootcamp

## Making

To build the code, just execute the command: `mvn clean package`.

## Running Locally

To run the code with an in-memory database for API testing, adjust the line in `application.properties` from:

`spring.datasource.url= jdbc:mysql://192.168.99.100:3306/lcstracker`

to

`spring.datasource.url= jdbc:mysql:memdb:lcstracker`

then make the code and call

`java -jar target/lcs-tracker-0.0.1-SNAPSHOT.jar`.

Using Postman with the localhost:8080 address will allow you to call the API and have a persistent in-memory db as long as the app is running.

## CICD

This code's `initial.Jenkinsfile` is equipped to handle a Jenkins pipeline. When using it in conjunction with the pipeline, ensure that the docker `default` machine is running on the specified default IP (`192.168.99.100`) and simply modify the pipeline's config to auto-build on various criteria (either a webhook or scheduled polling) and it will create docker images for both the SQL database and the API app.