FROM maven:3.6-openjdk-17 AS build

WORKDIR /app

COPY . /app

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-alpine

ENV SPRING_DATASOURCE_URL=jdbc:postgresql://isabelle.db.elephantsql.com:5432/hqmelazv
ENV SPRING_DATASOURCE_USERNAME=hqmelazv
ENV SPRING_DATASOURCE_PASSWORD=HZxy60a5f83ufMS899pwQmcFxbCETmJZ
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

COPY --from=build /app/target/design-0.0.1-SNAPSHOT.jar /app/design-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/app/design-0.0.1-SNAPSHOT.jar"]