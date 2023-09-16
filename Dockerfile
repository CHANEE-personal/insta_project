FROM openjdk:11

# build
ARG PACKAGE_JAR=build/libs/insta_project.jar

# run
EXPOSE 8080:8080
ADD ${PACKAGE_JAR} insta_project.jar
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=dev", "./insta_project.jar"]
