
FROM openjdk:21
WORKDIR /work/
COPY target/quarkus-app/lib/ ./lib/
COPY target/quarkus-app/quarkus-run.jar ./
COPY target/quarkus-app/app/ ./app/
COPY target/quarkus-app/quarkus/ ./quarkus/
EXPOSE 8080
ENTRYPOINT ["java","-jar","quarkus-run.jar","-Dquarkus.http.host=0.0.0.0"]