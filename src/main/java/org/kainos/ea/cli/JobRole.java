package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JobRole {
    private int jobRoleId;
    private String jobRoleName;
    private String jobRoleSpec;
    private String jobRoleLink;
    private String jobFamilyGroupName;
    private String jobBandLevel;
    private String jobRoleResponsibilities;


    @JsonCreator
    public JobRole(
            @JsonProperty("jobRoleId") int jobRoleId,
            @JsonProperty("jobRoleName") String jobRoleName,
            @JsonProperty("jobFamilyGroupName") String jobFamilyGroupName,
            @JsonProperty("jobBandLevel") String jobBandLevel,
            @JsonProperty("jobRoleLink") String jobRoleLink,
            @JsonProperty("jobRoleSpec") String jobRoleSpec,
            @JsonProperty("jobRoleResponsibilities") String jobRoleResponsibilities) {
        this.jobRoleId = jobRoleId;
        this.jobRoleName = jobRoleName;
        this.jobRoleSpec = jobRoleSpec;
        this.jobRoleLink = jobRoleLink;
        this.jobFamilyGroupName = jobFamilyGroupName;
        this.jobBandLevel = jobBandLevel;
        this.jobRoleResponsibilities = jobRoleResponsibilities;
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

    public String getJobRoleResponsibilities() {
        return jobRoleResponsibilities;
    }

    public void setJobRoleResponsibilities(String jobRoleResponsibilities) {
        this.jobRoleResponsibilities = jobRoleResponsibilities;
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

    public String getJobRoleSpec() {
        return jobRoleSpec;
    }

    public void setJobRoleSpec(String jobRoleSpec) {
        this.jobRoleSpec = jobRoleSpec;
    }

    public String getJobRoleLink() {
        return jobRoleLink;
    }

    public void setJobRoleLink(String jobRoleLink) {
        this.jobRoleLink = jobRoleLink;
    }
}
