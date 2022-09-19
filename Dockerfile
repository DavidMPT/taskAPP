FROM maven:3.6.3-openjdk-17 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:17-jdk
COPY --from=build /usr/src/app/target/Projecto-Softinsa-Container.jar /usr/app/Projecto-Softinsa-Container.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/Projecto-Softinsa-Container.jar"]