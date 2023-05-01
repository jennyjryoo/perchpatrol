FROM gradle:8-jdk17
WORKDIR /home/gradle
COPY . .
RUN gradle bootJar
EXPOSE 8080
ENTRYPOINT ["java","-jar","build/libs/app-0.0.1-SNAPSHOT.jar"]