FROM openjdk:17-oracle
COPY target/ServerManagementReporter-0.0.1-SNAPSHOT.jar reporter.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "reporter.jar"]
