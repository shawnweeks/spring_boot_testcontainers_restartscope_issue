Really simple example showing how Dynamic Properties don't get set.

### To Reproduce
1. In one window run `./mvnw spring-boot:test-run` and wait for the application to start.
2. Open a browser go to http://localhost:8080/first and http://localhost:8080/second. The first one errors and the second one doesn't