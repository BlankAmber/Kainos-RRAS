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
import org.kainos.ea.cli.*;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
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
    @Test
    @DisplayName("Integration test for adding individual job roles")
    void postEmployee_shouldReturnIdOfJobRole() {
        JobRoleRequest jobRoleRequest = new JobRoleRequest(
                "Test Engineer",
                1,
                8,
                "As a Test Engineer (Apprentice) in Kainos, you’ll work within a multi-skilled agile team, developing and executing functional automated and manual tests to help the team deliver working application software that meets user needs. You’ll do this whilst learning about new technologies and approaches, with talented colleagues who will help you learn, develop and grow.",
                "https://kainossoftwareltd.sharepoint.com/people/Job%20Specifications/Forms/AllItems.aspx?id=%2Fpeople%2FJob%20Specifications%2FEngineering%2FJob%20profile%20Trainee%20Test%20Engineer%20%28Trainee%29%2Epdf&parent=%2Fpeople%2FJob%20Specifications%2FEngineering",
                "Good technical ability including experience of an Object Oriented programming language and has a desire to develop their technical/test automation skills further. Good problem solving and analytical skills. We all work in teams here in Kainos – a proven ability of strong team skills, is crucial. Ability to carry out responsibilities in accordance with company policies, procedures and processes. Ability to deliver tasks within a given timeframe."

        );

        int id = APP.client().target("http://localhost:8080/api/job-role")
                .request()
                .post(Entity.entity(jobRoleRequest, MediaType.APPLICATION_JSON_TYPE))
                .readEntity(Integer.class);

        Assertions.assertNotNull(id);
    }
}
