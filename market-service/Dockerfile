FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/market-service-1.0.0.jar
COPY ${JAR_FILE} market-service.jar
ENTRYPOINT ["java","-jar","/market-service.jar"]