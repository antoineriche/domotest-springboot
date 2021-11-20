FROM hypriot/rpi-java

ADD domotest-0.0.1-SNAPSHOT.jar /opt/domotest-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "opt/domotest-0.0.1-SNAPSHOT.jar"]
