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
import org.kainos.ea.cli.RegisterDetails;
import org.kainos.ea.db.RoleID;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(DropwizardExtensionsSupport.class)
public class RegisterIT {
    static final DropwizardAppExtension<DropwizardWebServiceConfiguration> APP
            = new DropwizardAppExtension<>(
                    DropwizardWebServiceApplication.class, null,
            new ResourceConfigurationSourceProvider()
    );

    @Test
    @DisplayName("Test register with email that already exists")
    void register_withDuplicateEmail_shouldReturnBadRequestError() {
        String email = System.getenv("TEST_ADMIN_ACCOUNT_EMAIL");
        RegisterDetails registerDetails = new RegisterDetails(
                email, "FakePassword", RoleID.EMPLOYEE.getDBValue());

        Response response = APP.client().target("http://localhost:8080/api/register")
                .request()
                .post(Entity.entity(registerDetails, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }

    @Test
    @DisplayName("Test register with email of an invalid format")
    void register_withInvalidFormatEmail_shouldReturnBadRequestError() {
        RegisterDetails registerDetails = new RegisterDetails(
                "FakeEmail", "FakePassword", RoleID.EMPLOYEE.getDBValue());

        Response response = APP.client().target("http://localhost:8080/api/register")
                .request()
                .post(Entity.entity(registerDetails, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }

    @Test
    @DisplayName("Test register with short password")
    void register_withShortPassword_shouldReturnBadRequestError() {
        RegisterDetails registerDetails = new RegisterDetails(
                "DontUseThisEmail@please.com", "Pa!", RoleID.EMPLOYEE.getDBValue());

        Response response = APP.client().target("http://localhost:8080/api/register")
                .request()
                .post(Entity.entity(registerDetails, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }

    @Test
    @DisplayName("Test register with invalid role ID")
    void register_withInvalidRoleId_shouldReturnBadRequestError() {
        RegisterDetails registerDetails = new RegisterDetails(
                "DontUseThisEmail@please.com", "Password!", 0);

        Response response = APP.client().target("http://localhost:8080/api/register")
                .request()
                .post(Entity.entity(registerDetails, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }
}
