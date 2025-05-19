FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn package -DskipTests

FROM eclipse-temurin:21
WORKDIR /work/
COPY --from=build /app/target/quarkus-app/lib/ ./lib/
COPY --from=build /app/target/quarkus-app/app/ ./app/
COPY --from=build /app/target/quarkus-app/quarkus/ ./quarkus/
COPY --from=build /app/target/quarkus-app/quarkus-run.jar ./
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "quarkus-run.jar", "-Dquarkus.http.host=0.0.0.0"]