## syntax=docker/dockerfile:1
#FROM openjdk:11
#COPY . /app
#WORKDIR /app
#RUN ./gradlew clean build
#CMD ["./gradlew run"]

# file: Dockerfile

FROM rusnyder/docker-dropwizard:8-jre-alpine

# Copy the DW uberjar, and set it to be run directly
ARG JAR_FILE="build/libs/SampleDropwizardProject-1.0-SNAPSHOT.jar"
COPY /${JAR_FILE} /${JAR_FILE}
ENV DW_UBERJAR=/${JAR_FILE}

# Copy the config template
ARG CONFIG_TEMPLATE="config.yml"
COPY ${CONFIG_TEMPLATE} /${CONFIG_TEMPLATE}
ENV DW_CONFIG_TEMPLATE=/${CONFIG_TEMPLATE}

# Run the "server" command (optional; 'server' is the default)
CMD ["server"]