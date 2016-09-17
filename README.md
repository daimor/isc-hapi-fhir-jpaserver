## HAPI-FHIR JPAServer
This project is an example of [HAPI-FHIR](https://github.com/jamesagnew/hapi-fhir) JPAServer which is used InterSystems Caché as a backend.
### How to use
You need to have Java and Maven installed before using. Clone this project.
to build project you may use this command
```
mvn install
```
And then you can launch this servlet with jetty
```
mvn jetty:run
```
By default it is used Caché Server on `localhost:1972` and Namespace `FHIR`. You can change this settings in file [FhirServerConfig.java](src/main/java/cz/csystem/fhir/jpa/FhirServerConfig.java). Tested with 2016.2.
