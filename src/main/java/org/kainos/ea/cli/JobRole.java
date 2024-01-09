package org.kainos.ea.cli;


public class JobRole {

    private int jobRoleId;
    private String jobRoleName;

    private String jobRoleSpec;
    private String jobRoleLink;

    private String jobFamilyGroupName;
    private String jobRoleBandLevel;
    private String jobResponsibilities;

    private String jobManagementLevel;


    public JobRole() {
        // Default constructor
    }

    public JobRole(int jobRoleId, String jobRoleName, String jobRoleSpec, String jobRoleLink, String jobResponsibilities, String jobRoleBandLevel, String jobManagementLevel) {
        this.jobRoleId = jobRoleId;
        this.jobRoleName = jobRoleName;
        this.jobRoleSpec = jobRoleSpec;
        this.jobRoleLink = jobRoleLink;
        this.jobResponsibilities = jobResponsibilities;
        this.jobRoleBandLevel = jobRoleBandLevel;
        this.jobManagementLevel = jobManagementLevel;
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


    public String getJobFamilyGroupName() {
        return jobFamilyGroupName;
    }

    public void setJobFamilyGroupName(String jobFamilyGroupName) {
        this.jobFamilyGroupName = jobFamilyGroupName;
    }
    public String getJobRoleBandLevel() {
        return jobRoleBandLevel;
    }

    public void setJobRoleBandLevel(String jobRoleBandLevel) {
        this.jobRoleBandLevel = jobRoleBandLevel;
    }
    public String getJobResponsibilities() {
        return jobResponsibilities;
    }

    public void setJobResponsibilities(String jobResponsibilities) {
        this.jobResponsibilities = jobResponsibilities;
    }

    public String getJobManagementLevel() {
        return jobManagementLevel;
    }

    public void setJobManagementLevel(String jobManagementLevel) {
        this.jobManagementLevel = jobManagementLevel;
    }
}
