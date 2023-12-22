package org.kainos.ea.core;

import org.kainos.ea.cli.JobRoleRequest;
import org.kainos.ea.client.*;

public class JobRoleValidator {

    public boolean isValidJobRole(JobRoleRequest jobRoleRequest) throws JobRoleNameLengthException, JobFamilyGroupIdException, JobBandLevelIdException, JobRoleSpecLengthException, JobRoleLinkLengthException, JobResponsibilitiesLengthException {
        if (jobRoleRequest.getJobRoleName().length() > 50) {
            throw new JobRoleNameLengthException();
        }

        if (jobRoleRequest.getJobFamilyGroupId() < 1) {
            throw new JobFamilyGroupIdException();
        }

        if (jobRoleRequest.getJobBandLevelId() < 1) {
            throw new JobBandLevelIdException();
        }

        if (jobRoleRequest.getJobRoleSpec().length() > 4000) {
            throw new JobRoleSpecLengthException();
        }

        if (jobRoleRequest.getJobRoleLink().length() > 1000) {
            throw new JobRoleLinkLengthException();
        }

        if (jobRoleRequest.getJobResponsibilities().length() > 4000) {
            throw new JobResponsibilitiesLengthException();
        }

        return true;
    }
}
