package org.kainos.ea.core;

import org.junit.jupiter.api.Test;
import org.kainos.ea.cli.JobRoleRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class JobRoleValidatorTest {
    private final JobRoleValidator jobRoleValidator = new JobRoleValidator();

    @Test
    public void isValidJobRole_whenValidJobRole_shouldReturnNull() {
        JobRoleRequest jobRoleRequest = new JobRoleRequest(
                "Test Engineer",
                1,
                8,
                "Valid job role spec",
                "Valid job role link",
                "Valid job responsibilities"
        );

        assertNull(jobRoleValidator.isValidJobRole(jobRoleRequest));
    }

    @Test
    public void isValidJobRole_whenJobRoleNameTooLong() {
        JobRoleRequest jobRoleRequest = new JobRoleRequest(
                "This is a job role name that is definitely longer than fifty characters",
                1,
                1,
                "Valid job role spec",
                "Valid job role link",
                "Valid job responsibilities"
        );

        assertEquals("Job role name length too long",
                jobRoleValidator.isValidJobRole(jobRoleRequest));
    }

    @Test
    public void isValidJobRole_whenJobFamilyGroupIdTooLow_shouldReturnString() {
        JobRoleRequest jobRoleRequest = new JobRoleRequest(
                "Valid job role name",
                0,
                1,
                "Valid job role spec",
                "Valid job role link",
                "Valid job responsibilities"
        );

        assertEquals("Invalid job family group",
                jobRoleValidator.isValidJobRole(jobRoleRequest));
    }

    @Test
    public void isValidJobRole_whenJobBandLevelIdTooLow_shouldReturnString() {
        JobRoleRequest jobRoleRequest = new JobRoleRequest(
                "Valid job role name",
                1,
                0,
                "Valid job role spec",
                "Valid job role link",
                "Valid job responsibilities"
        );

        assertEquals("Invalid job band level",
                jobRoleValidator.isValidJobRole(jobRoleRequest));
    }

    @Test
    public void isValidJobRole_whenJobRoleSpecTooLong_shouldReturnString() {
        JobRoleRequest jobRoleRequest = new JobRoleRequest(
                "Valid job role name",
                1,
                1,
                new String(new char[5000]).replace("\0", "a"),
                "Valid job role link",
                "Valid job responsibilities"
        );

        assertEquals("Job role specification length too long",
                jobRoleValidator.isValidJobRole(jobRoleRequest));
    }

    @Test
    public void isValidJobRole_whenJobRoleLinkTooLong_shouldReturnString() {
        JobRoleRequest jobRoleRequest = new JobRoleRequest(
                "Valid job role name",
                1,
                1,
                "Valid job role spec",
                new String(new char[2000]).replace("\0", "a"),
                "Valid job responsibilities"
        );

        assertEquals("Job role link length too long",
                jobRoleValidator.isValidJobRole(jobRoleRequest));
    }

    @Test
    public void isValidJobRole_whenJobResponsibilitiesTooLong_shouldReturnString() {
        JobRoleRequest jobRoleRequest = new JobRoleRequest(
                "Valid job role name",
                1,
                1,
                "Valid job role spec",
                "Valid job role link",
                new String(new char[5000]).replace("\0", "a")
        );

        assertEquals("Job responsibilities length too long",
                jobRoleValidator.isValidJobRole(jobRoleRequest));
    }
}
