package org.kainos.ea.integration;

import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.DropwizardWebServiceApplication;
import org.kainos.ea.DropwizardWebServiceConfiguration;
import org.kainos.ea.cli.JobRole;
import org.kainos.ea.cli.Login;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(DropwizardExtensionsSupport.class)
public class JobRolesIT {
    static final DropwizardAppExtension<DropwizardWebServiceConfiguration> APP
            = new DropwizardAppExtension<>(
                    DropwizardWebServiceApplication.class, null,
            new ResourceConfigurationSourceProvider()
    );

    @Test
    @DisplayName("Test GET /all-job-roles with valid jwt returns a list of jobs")
    void getJobRoles_withValidJWT_shouldReturnListOfJobRoles() {
        String email = System.getenv("TEST_EMPLOYEE_ACCOUNT_EMAIL");
        String password = System.getenv("TEST_EMPLOYEE_ACCOUNT_PASSWORD");
        Login login = new Login(email, password);

        String jwt = APP.client().target("http://localhost:8080/api/login")
                .request()
                .post(Entity.entity(login, MediaType.APPLICATION_JSON_TYPE))
                .readEntity(String.class);

        List<JobRole> jobRolesList = APP.client()
                .target("http://localhost:8080/api/all-job-roles")
                .request()
                .header("Authorisation", "Bearer " + jwt)
                .get(List.class);

        assertFalse(jobRolesList.isEmpty());
    }

    @Test
    @DisplayName("Test GET /all-job-roles with invalid jwt returns error 400")
    void getJobRoles_withInvalidJWT_shouldReturn() {
        int statusCode = APP.client()
                .target("http://localhost:8080/api/all-job-roles?jwt=fakejwt")
                .request()
                .get()
                .getStatus();
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), statusCode);
    }
}
