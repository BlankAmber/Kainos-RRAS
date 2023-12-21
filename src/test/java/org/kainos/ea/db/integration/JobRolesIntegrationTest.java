package org.kainos.ea.db.integration;

import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.DropwizardWebServiceConfiguration;
import org.kainos.ea.DropwizardWebServiceApplication;
import org.kainos.ea.cli.JobBandLevel;
import org.kainos.ea.cli.JobFamilyGroup;
import org.kainos.ea.cli.JobResponsibilities;
import org.kainos.ea.cli.JobRole;

import javax.ws.rs.core.Response;
import java.util.List;

@ExtendWith(DropwizardExtensionsSupport.class)
public class JobRolesIntegrationTest {

    static final DropwizardAppExtension<DropwizardWebServiceConfiguration> APP = new DropwizardAppExtension<>(
            DropwizardWebServiceApplication.class, null,
            new ResourceConfigurationSourceProvider()
    );


    @Test
    @DisplayName("Integration test for returning job roles")
    void getJobRoles_shouldReturnListOfJobRoles() {
        List<JobResponsibilities> response = APP.client().target("http://localhost:8080/api/all-job-roles")
                .request()
                .get(List.class);

        Assertions.assertTrue(response.size() > 0);
    }

    @Test
    @DisplayName("Integration test for returning individual job roles")
    void getJobRoles_shouldReturnJobRole() {
        Response response = APP.client().target("http://localhost:8080/api/all-job-roles/1")
                .request()
                .get();

        Assertions.assertEquals(200,response.getStatus());
        Assertions.assertEquals(1, response.readEntity(JobRole.class).getJobRoleId());
    }
}
