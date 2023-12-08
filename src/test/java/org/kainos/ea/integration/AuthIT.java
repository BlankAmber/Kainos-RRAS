package org.kainos.ea.integration;

import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.DropwizardWebServiceApplication;
import org.kainos.ea.DropwizardWebServiceConfiguration;
import org.kainos.ea.cli.Login;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(DropwizardExtensionsSupport.class)
public class AuthIT {
    static final DropwizardAppExtension<DropwizardWebServiceConfiguration> APP =
            new DropwizardAppExtension<>(
                    DropwizardWebServiceApplication.class, null,
                    new ResourceConfigurationSourceProvider()
    );

    @Test
    @DisplayName("Test valid login to an admin account")
    void postLogin_withValidAdminAccount_shouldReturnToken() {
        Login login = new Login(
                System.getenv("TEST_ADMIN_ACCOUNT_USERNAME"),
                System.getenv("TEST_ADMIN_ACCOUNT_PASSWORD")
        );

        String token = APP.client().target("http://localhost:8080/api/login")
                .request()
                .post(Entity.entity(login, MediaType.APPLICATION_JSON_TYPE))
                .readEntity(String.class);
        assertNotNull(token);
    }

    @Test
    @DisplayName("Test valid login to an employee account")
    void postLogin_withValidEmployeeAccount_shouldReturnToken() {
        Login login = new Login(
                System.getenv("TEST_EMPLOYEE_ACCOUNT_USERNAME"),
                System.getenv("TEST_EMPLOYEE_ACCOUNT_PASSWORD")
        );

        String token = APP.client().target("http://localhost:8080/api/login")
                .request()
                .post(Entity.entity(login, MediaType.APPLICATION_JSON_TYPE))
                .readEntity(String.class);
        assertNotNull(token);
    }

    @Test
    @DisplayName("Test login invalid password to an admin account")
    void postLogin_withInvalidPasswordForAdminAccount_shouldReturnBadRequestError() {
        Login login = new Login(
                System.getenv("TEST_ADMIN_ACCOUNT_USERNAME"),
                "TestPassword"
        );

        Response response = APP.client().target("http://localhost:8080/api/login")
                .request()
                .post(Entity.entity(login, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }

    @Test
    @DisplayName("Test login invalid password to an employee account")
    void postLogin_withInvalidPasswordForEmployeeAccount_shouldReturnBadRequestError() {
        Login login = new Login(
                System.getenv("TEST_EMPLOYEE_ACCOUNT_USERNAME"),
                "TestPassword"
        );

        Response response = APP.client().target("http://localhost:8080/api/login")
                .request()
                .post(Entity.entity(login, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }

    @Test
    @DisplayName("Test login invalid account info")
    void postLogin_withInvalidAccountInfo_shouldReturnErrorBadRequestError() {
        Login login = new Login(
                "NotARealUser",
                "NotARealPassword"
        );

        Response response = APP.client().target("http://localhost:8080/api/login")
                .request()
                .post(Entity.entity(login, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }
}
