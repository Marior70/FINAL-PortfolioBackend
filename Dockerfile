FROM amazoncorretto:17-alpine-jdk
LABEL author="Mario Lerman"
COPY target/backend-0.0.1-SNAPSHOT.jar portfolio-mrl-api.jar
ENTRYPOINT [ "java","-jar","/portfolio-mrl-api.jar" ]