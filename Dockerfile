FROM rsunix/yourkit-openjdk17

ADD target/TestIntegration.jar TestIntegration.jar
ENTRYPOINT ["java", "-jar","TestIntegration.jar"]
EXPOSE 8080
