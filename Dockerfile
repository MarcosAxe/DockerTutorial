FROM adoptopenjdk:11-jre-hotspot

COPY target/dockertutorial.jar dockertutorial.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "dockertutorial.jar"]