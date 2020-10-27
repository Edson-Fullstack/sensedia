FROM openjdk:8
ADD target/craft-beer.jar	craft-beer.jar
COPY	target/craft-beer.jar	craft-beer.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "craft-beer.jar"]