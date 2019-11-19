FROM java:8-jdk-alpine

COPY ./target/ShakeProject.jar /usr/app/

ENTRYPOINT ["java","-jar","usr/app/ShakeProject.jar"]
