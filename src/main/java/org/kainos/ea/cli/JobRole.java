package org.kainos.ea.cli;

public class JobRole {

    private int jobRoleId;
    private String jobRoleName;

    public JobRole(int jobRoleId, String jobRoleName) {
        this.jobRoleId = jobRoleId;
        this.jobRoleName = jobRoleName;
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
