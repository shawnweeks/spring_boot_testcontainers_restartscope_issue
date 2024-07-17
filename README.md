Really simple example showing how the DynamicPropertyRegistry doesn't get set on dev tools reload.

### To Reproduce
1. In one window run `./mvnw spring-boot:test-run` and wait for the application to start.
2. In another window run `./mvnw compile` and wait for dev tools to rebuild. Notice how the application no longer starts.