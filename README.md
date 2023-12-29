# Kainos-RRAS-API

Config
---
1. The following environment variables need to be set to run the backend:
```
DB_USERNAME
DB_PASSWORD
DB_HOST
DB_NAME
JWT_SECRET
```
2. If running integration tests, then the following environment variables need to be set:
```
TEST_ADMIN_ACCOUNT_USERNAME
TEST_ADMIN_ACCOUNT_PASSWORD
TEST_EMPLOYEE_ACCOUNT_EMAIL
TEST_EMPLOYEE_ACCOUNT_PASSWORD
```

How to start the application
---
1. Run `mvn clean install -DskipTests` to build your application
2. Start application with `java -jar target/DropwizardWebService-1.0-SNAPSHOT.jar server config.yml`
3. To check that your application is running enter url `http://localhost:8080`

Swagger
---
To see your applications Swagger UI `http://localhost:8080/swagger`

Tests
---
1. Run `mvn clean test` to run unit tests
2. Run `mvn clean verify -DskipUnitTests` to run integration tests

Linter
---
1. Run `mvn checkstyle:check`
