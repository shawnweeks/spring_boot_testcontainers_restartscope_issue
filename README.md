Really simple example showing how the DynamicPropertyRegistry doesn't get set on dev tools reload. Simply startup the app and verify that you see the random redis port at http://localhost:8080 and then save a file so dev tools does a reload. It will error because the properties are no longer set.

`./mvnw spring-boot:test-run`