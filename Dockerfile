FROM maven:3-openjdk-8-slim AS build
WORKDIR /tmp/dhis2-fhir-adapter
ARG DHIS2_HOME=/app

COPY . /tmp/dhis2-fhir-adapter

# create package
RUN mvn clean package -DskipTests

# create DHIS2_HOME/services/fhir-adapter configuration folder here https://github.com/opensrp/dhis2-fhir-adapter#configuration
RUN mkdir -p ${DHIS2_HOME}/services/fhir-adapter \
    && cp /tmp/dhis2-fhir-adapter/app/target/dhis2-fhir-adapter.war ${DHIS2_HOME}/main.war

FROM openjdk:8-jre-slim AS deploy

# specify the DHIS2_HOME environment variable
ENV DHIS2_HOME=/app

# create opensrp user
ARG UID=10001
ARG GID=${UID}
RUN groupadd -g ${GID} opensrp \
    && useradd -u ${UID} -g ${GID} opensrp

COPY --chown=opensrp:opensrp --from=build ${DHIS2_HOME} ${DHIS2_HOME}

USER opensrp

WORKDIR ${DHIS2_HOME}

CMD java -jar ${DHIS2_HOME}/main.war
