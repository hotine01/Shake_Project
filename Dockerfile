FROM java:8-jdk-alpine

COPY ./target/Shake_Project.jar /usr/app/

ENTRYPOINT ["java","-jar","usr/app/Shake_Project.jar"]
