FROM openjdk

EXPOSE 7070

COPY target/m154-crm-web-maven-0.0.1-SNAPSHOT-shaded.jar ./app.jar 

cmd ["java", "-jar", "app.jar"]