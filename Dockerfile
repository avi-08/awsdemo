FROM openjdk:11-ea-9-jre

COPY target/awsdemo-0.0.1-SNAPSHOT.jar /opt/awsdemo-0.0.1-SNAPSHOT.jar

WORKDIR /opt

CMD ["java", "-jar", "awsdemo-0.0.1-SNAPSHOT.jar"]