package org.kainos.ea.integration;

import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.Assertions;
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
    @DisplayName("Test GET /all-job-roles with no jwt returns error 400")
    void getJobRoles_withNoJWT_shouldReturnError400() {
        int statusCode = APP.client()
                .target("http://localhost:8080/api/all-job-roles")
                .request()
                .get()
                .getStatus();
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), statusCode);
    }

    @Test
    @DisplayName("Integration test for returning individual job roles")
    void getJobRoles_withId_shouldReturnJobRole() {
        String email = System.getenv("TEST_EMPLOYEE_ACCOUNT_EMAIL");
        String password = System.getenv("TEST_EMPLOYEE_ACCOUNT_PASSWORD");
        Login login = new Login(email, password);
        String jwt = APP.client().target("http://localhost:8080/api/login")
                .request()
                .post(Entity.entity(login, MediaType.APPLICATION_JSON_TYPE))
                .readEntity(String.class);

        Response response =
                APP.client().target("http://localhost:8080/api/all-job-roles/1")
                        .request()
                        .header("Authorisation", "Bearer " + jwt)
                        .get();

        Assertions.assertEquals(200, response.getStatus());
        Assertions.assertEquals(1, response.readEntity(JobRole.class).getJobRoleId());
    }
}
