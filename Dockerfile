FROM openjdk:8
ADD target/craft-beer-0.0.1-SNAPSHOT.jar	craft-beer-0.0.1-SNAPSHOT.jar
COPY	target/craft-beer-0.0.1-SNAPSHOT.jar	craft-beer-0.0.1-SNAPSHOT.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "craft-beer-0.0.1-SNAPSHOT.jar"]