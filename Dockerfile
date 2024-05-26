FROM maven:3.6-openjdk-17 AS build

WORKDIR /app

COPY . /app

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-alpine

ENV SPRING_DATASOURCE_URL=jdbc:postgresql://isabelle.db.elephantsql.com:5432/nnueidwa
ENV SPRING_DATASOURCE_USERNAME=nnueidwa
ENV SPRING_DATASOURCE_PASSWORD=sPrDaNTuh0rIM2yqMTGwJkDf6-wsCHDS
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

COPY --from=build /app/target/order-0.0.1-SNAPSHOT.jar /app/order-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/app/order-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080