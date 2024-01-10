package org.kainos.ea.db.validator;
import org.junit.jupiter.api.Test;
import org.kainos.ea.cli.JobRoleRequest;
import org.kainos.ea.client.*;
import org.kainos.ea.core.JobRoleValidator;

import static org.junit.jupiter.api.Assertions.*;

public class JobRoleValidatorTest {

    JobRoleValidator jobRoleValidator = new JobRoleValidator();

    @Test
    public void isValidJobRole_shouldReturnNull_whenValidJobRole() throws JobRoleNameLengthException, JobFamilyGroupIdException, JobBandLevelIdException, JobRoleSpecLengthException, JobRoleLinkLengthException, JobResponsibilitiesLengthException {
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
    public void isValidJobRole_shouldThrowJobRoleNameLengthException_whenJobRoleNameTooLong() {
        JobRoleRequest jobRoleRequest = new JobRoleRequest(
                "This is a job role name that is definitely longer than fifty characters",
                1,
                1,
                "Valid job role spec",
                "Valid job role link",
                "Valid job responsibilities"
        );

        assertThrows(JobRoleNameLengthException.class,
                () -> jobRoleValidator.isValidJobRole(jobRoleRequest));
    }

    @Test
    public void isValidJobRole_shouldThrowJobFamilyGroupIdException_whenJobFamilyGroupIdTooLow(){
        JobRoleRequest jobRoleRequest = new JobRoleRequest(
                "Valid job role name",
                0,
                1,
                "Valid job role spec",
                "Valid job role link",
                "Valid job responsibilities"
        );

        assertThrows(JobFamilyGroupIdException.class,
                () -> jobRoleValidator.isValidJobRole(jobRoleRequest));
    }

    @Test
    public void isValidJobRole_shouldThrowJobBandLevelIdException_whenJobBandLevelIdTooLow() {
        JobRoleRequest jobRoleRequest = new JobRoleRequest(
                "Valid job role name",
                1,
                0,
                "Valid job role spec",
                "Valid job role link",
                "Valid job responsibilities"
        );

        assertThrows(JobBandLevelIdException.class,
                () -> jobRoleValidator.isValidJobRole(jobRoleRequest));
    }

    @Test
    public void isValidJobRole_shouldThrowJobRoleSpecLengthException_whenJobRoleSpecTooLong(){
        JobRoleRequest jobRoleRequest = new JobRoleRequest(
                "Valid job role name",
                1,
                1,
                "This is a job role spec that is definitely longer than four thousand characters" + new String(new char[4000]).replace("\0", "a"),
                "Valid job role link",
                "Valid job responsibilities"
        );

        assertThrows(JobRoleSpecLengthException.class,
                () -> jobRoleValidator.isValidJobRole(jobRoleRequest));
    }

    @Test
    public void isValidJobRole_shouldThrowJobRoleLinkLengthException_whenJobRoleLinkTooLong(){
        JobRoleRequest jobRoleRequest = new JobRoleRequest(
                "Valid job role name",
                1,
                1,
                "Valid job role spec",
                "This is a job role link that is definitely longer than one thousand characters" + new String(new char[1000]).replace("\0", "a"),
                "Valid job responsibilities"
        );

        assertThrows(JobRoleLinkLengthException.class,
                () -> jobRoleValidator.isValidJobRole(jobRoleRequest));
    }

    @Test
    public void isValidJobRole_shouldThrowJobResponsibilitiesLengthException_whenJobResponsibilitiesTooLong() {
        JobRoleRequest jobRoleRequest = new JobRoleRequest(
                "Valid job role name",
                1,
                1,
                "Valid job role spec",
                "Valid job role link",
                "These are job responsibilities that are definitely longer than four thousand characters" + new String(new char[4000]).replace("\0", "a")
        );

        assertThrows(JobResponsibilitiesLengthException.class,
                () -> jobRoleValidator.isValidJobRole(jobRoleRequest));
    }

}
