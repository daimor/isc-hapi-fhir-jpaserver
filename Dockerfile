FROM tomcat

LABEL DESCRIPTION="TOMCAT HAPI-FHIR Test Server"

#UPDATE PMS AND INSTALL NEEDED APPS
RUN apt-get update -y \
    && apt-get install -y vim \
    && apt-get install -y curl

RUN mkdir -p /usr/local/tomcat/conf/Catalina/localhost \
    && mkdir -p /var/lib/hapi \
    && rm -r /usr/local/tomcat/webapps

WORKDIR /var/lib/hapi

COPY target/hapi-fhir-jpaserver.war .
COPY hapi-fhir-jpaserver.xml  /usr/local/tomcat/conf/Catalina/localhost/ROOT.xml

VOLUME /var/lib/hapi/jpaserver_derby_files

EXPOSE 8080