FROM gradle:7.4-jdk11-alpine as builder
WORKDIR /build

COPY build.gradle settings.gradle /build/
RUN gradle build -x test --parallel --continue > /dev/null 2>&1 || true

COPY . /build
RUN gradle build -x test --parallel

# APP
FROM openjdk:11.0-slim
WORKDIR /app

COPY --from=builder /build/build/libs/insta_project.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "insta_project.jar"]
