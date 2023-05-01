FROM gradle:6.8-jdk11 as BUILD

COPY . /app

WORKDIR /app

RUN ./gradlew build --no-daemon

#---

FROM openjdk:11-jre-slim

COPY --from=build /app/build/libs/shortlife-1.0-all.jar /app/shortlife-1.0-all.jar

WORKDIR /app

ENTRYPOINT ["java","-jar","shortlife-1.0-all.jar"]
