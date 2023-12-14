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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(DropwizardExtensionsSupport.class)
public class JobRolesIT {
    static final DropwizardAppExtension<DropwizardWebServiceConfiguration> APP
            = new DropwizardAppExtension<>(
                    DropwizardWebServiceApplication.class, null,
            new ResourceConfigurationSourceProvider()
    );

    @Test
    @DisplayName("Test GET /all-job-roles returns a list of jobs")
    void getJobRoles_shouldReturnListOfJobRoles() {
        List<JobRole> jobRolesList = APP.client()
                .target("http://localhost:8080/api/all-job-roles")
                .request()
                .get(List.class);

        assertFalse(jobRolesList.isEmpty());
    }
}
