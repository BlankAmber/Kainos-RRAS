package org.kainos.ea.cli;

public class JobFamilyGroup {

    private int jobRoleId;
    private String jobRoleName;

    private String jobFamilyGroupName;


    public JobFamilyGroup(int jobRoleId, String jobRoleName, String jobFamilyGroupName) {
        this.jobRoleId = jobRoleId;
        this.jobRoleName = jobRoleName;
        this.jobFamilyGroupName = jobFamilyGroupName;
    }

    public JobFamilyGroup(String jobFamilyGroupName) {
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
