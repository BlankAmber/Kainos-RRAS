package org.kainos.ea.core;

import org.kainos.ea.cli.JobRoleRequest;
import org.kainos.ea.client.JobBandLevelIdException;
import org.kainos.ea.client.JobFamilyGroupIdException;
import org.kainos.ea.client.JobResponsibilitiesLengthException;
import org.kainos.ea.client.JobRoleLinkLengthException;
import org.kainos.ea.client.JobRoleNameLengthException;
import org.kainos.ea.client.JobRoleSpecLengthException;

public class JobRoleValidator {
    private static final int MIN_ID = 1;
    private static final int MAX_JOB_ROLE_NAME_LENGTH = 50;
    private static final int MAX_JOB_SPEC_LENGTH = 4000;
    private static final int MAX_JOB_LINK_LENGTH = 1000;
    private static final int MAX_JOB_RESPONSIBILITIES_LENGTH = 4000;

    public String isValidJobRole(JobRoleRequest jobRoleRequest) {
        try {
            if (jobRoleRequest.getJobRoleName().length() > MAX_JOB_ROLE_NAME_LENGTH) {
                throw new JobRoleNameLengthException();
            }

            if (jobRoleRequest.getJobFamilyGroupId() < MIN_ID) {
                throw new JobFamilyGroupIdException();
            }

            if (jobRoleRequest.getJobBandLevelId() < MIN_ID) {
                throw new JobBandLevelIdException();
            }

            if (jobRoleRequest.getJobRoleSpec().length() > MAX_JOB_SPEC_LENGTH) {
                throw new JobRoleSpecLengthException();
            }

            if (jobRoleRequest.getJobRoleLink().length() > MAX_JOB_LINK_LENGTH) {
                throw new JobRoleLinkLengthException();
            }

            if (jobRoleRequest.getJobResponsibilities()
                    .length() > MAX_JOB_RESPONSIBILITIES_LENGTH) {
                throw new JobResponsibilitiesLengthException();
            }
        } catch (Exception e) {
            return e.getMessage();
        }

        return null;
    }
}
