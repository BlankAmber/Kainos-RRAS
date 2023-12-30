package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JobFamilyGroup {
    private int jobRoleId;
    private String jobRoleName;
    private String jobFamilyGroupName;

    @JsonCreator
    public JobFamilyGroup(
            @JsonProperty("jobRoleId") int jobRoleId,
            @JsonProperty("jobRoleName") String jobRoleName,
            @JsonProperty("jobFamilyGroupName") String jobFamilyGroupName) {
        this.jobRoleId = jobRoleId;
        this.jobRoleName = jobRoleName;
        this.jobFamilyGroupName = jobFamilyGroupName;
    }

    public int getJobRoleId() {
        return jobRoleId;
    }

    public void setJobRoleId(int jobRoleId) {
        this.jobRoleId = jobRoleId;
    }

    public String getJobRoleName() {
        return jobRoleName;
    }

    public void setJobRoleName(String jobRoleName) {
        this.jobRoleName = jobRoleName;
    }

    public String getJobFamilyGroupName() {
        return jobFamilyGroupName;
    }

    public void setJobFamilyGroupName(String jobFamilyGroupName) {
        this.jobFamilyGroupName = jobFamilyGroupName;
    }
}
