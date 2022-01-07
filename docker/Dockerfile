FROM node as frontend
WORKDIR /tmp
COPY ./front ./frontend
WORKDIR /tmp/frontend
RUN yarn install
RUN yarn build:docker

FROM gradle:7.3.3-jdk11 as backend
WORKDIR /tmp
COPY ./backend ./backend
WORKDIR /tmp/backend
COPY --from=frontend /tmp/frontend/build /tmp/backend/src/main/resources/public
RUN ./gradlew build -x test

FROM openjdk:19-jdk
COPY --from=backend /tmp/backend/build/libs/backend-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c",  "java -jar app.jar"]
