package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JobRoleRequest {

    private String jobRoleName;
    private int jobFamilyGroupId;
    private int jobBandLevelId;
    private String jobRoleSpec;
    private String jobRoleLink;
    private String jobResponsibilities;

    @JsonCreator
    public JobRoleRequest(
            @JsonProperty("job_role_name") String jobRoleName,
            @JsonProperty("job_family_id") int jobFamilyGroupId,
            @JsonProperty("management_level_id") int jobBandLevelId,
            @JsonProperty("specification_summary") String jobRoleSpec,
            @JsonProperty("sharepoint_link") String jobRoleLink,
            @JsonProperty("responsibilities") String jobResponsibilities) {
        this.setJobRoleName(jobRoleName);
        this.setJobFamilyGroupId(jobFamilyGroupId);
        this.setJobBandLevelId(jobBandLevelId);
        this.setJobRoleSpec(jobRoleSpec);
        this.setJobRoleLink(jobRoleLink);
        this.setJobResponsibilities(jobResponsibilities);

    }

    public String getJobRoleName() {
        return jobRoleName;
    }

    public void setJobRoleName(String jobRoleName) {
        this.jobRoleName = jobRoleName;
    }

    public int getJobFamilyGroupId() {
        return jobFamilyGroupId;
    }

    public void setJobFamilyGroupId(int jobFamilyGroupId) {
        this.jobFamilyGroupId = jobFamilyGroupId;
    }

    public int getJobBandLevelId() {
        return jobBandLevelId;
    }

    public void setJobBandLevelId(int jobBandLevelId) {
        this.jobBandLevelId = jobBandLevelId;
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

    public String getJobResponsibilities() {
        return jobResponsibilities;
    }

    public void setJobResponsibilities(String jobResponsibilities) {
        this.jobResponsibilities = jobResponsibilities;
    }
}
