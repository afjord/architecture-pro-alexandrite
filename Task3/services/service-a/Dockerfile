FROM gradle:8.14-jdk21 AS builder
WORKDIR /app
COPY . .
RUN gradle bootJar --no-daemon

FROM eclipse-temurin:21-jre
WORKDIR /app
RUN curl -L -o /app/opentelemetry-javaagent.jar \
  https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar

ENV JAVA_TOOL_OPTIONS="-javaagent:/app/opentelemetry-javaagent.jar" \
    OTEL_TRACES_EXPORTER=zipkin \
    OTEL_EXPORTER_ZIPKIN_ENDPOINT=http://simplest-collector.default.svc.cluster.local:9411/api/v2/spans \
    OTEL_SERVICE_NAME=service-a \
    OTEL_METRICS_EXPORTER=none \
    OTEL_LOGS_EXPORTER=none

COPY --from=builder /app/build/libs/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]