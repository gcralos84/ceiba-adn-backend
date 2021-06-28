FROM adoptopenjdk:11-jre-hotspot as builder
EXPOSE  8080
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=build/libs/citamedica-1.0.jar
ADD ${JAR_FILE} citamedica-1.0.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/citamedica-1.0.jar"]
