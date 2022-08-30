FROM maven:3.8.6-openjdk-18-slim
MAINTAINER Andrey
ENV PROJECT_DIR=/opt/project
RUN mkdir -p $PROJECT_DIR
WORKDIR $PROJECT_DIR
ADD ./pom.xml $PROJECT_DIR
RUN mvn dependency:resolve
ADD ./src/ $PROJECT_DIR/src
RUN mvn clean package -DskipTests
FROM openjdk:17-slim
ENV PROJECT_DIR=/opt/project
RUN mkdir -p $PROJECT_DIR
WORKDIR $PROJECT_DIR
COPY --from=0 $PROJECT_DIR/target/* $PROJECT_DIR/
EXPOSE 8081
RUN ["ls", "-la", "/opt/project/"]
CMD ["java", "-jar", "/opt/project/Exchange-0.0.1-SNAPSHOT.jar"]