package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JobRoleMatrix {
    private int jobRoleId;
    private String jobRoleName;
    private String jobFamilyGroupName;
    private String jobBandLevel;
    private String jobFamilyGroup;


    @JsonCreator
    public JobRoleMatrix(
            @JsonProperty("jobRoleId") int jobRoleId,
            @JsonProperty("jobRoleName") String jobRoleName,
            @JsonProperty("jobFamilyGroupName") String jobFamilyGroupName,
            @JsonProperty("jobBandLevel") String jobBandLevel,
            @JsonProperty("jobFamilyGroup") String jobFamilyGroup) {
        this.jobRoleId = jobRoleId;
        this.jobRoleName = jobRoleName;
        this.jobFamilyGroupName = jobFamilyGroupName;
        this.jobBandLevel = jobBandLevel;
        this.jobFamilyGroup = jobFamilyGroup;
    }

    public String getJobFamilyGroup() {
        return jobFamilyGroup;
    }

    public void setJobFamilyGroup(String jobFamilyGroup) {
        this.jobFamilyGroup = jobFamilyGroup;
    }


    public String getJobFamilyGroupName() {
        return jobFamilyGroupName;
    }

    public void setJobFamilyGroupName(String jobFamilyGroupName) {
        this.jobFamilyGroupName = jobFamilyGroupName;
    }

    public String getJobBandLevel() {
        return jobBandLevel;
    }

    public void setJobBandLevel(String jobBandLevel) {
        this.jobBandLevel = jobBandLevel;
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
}
