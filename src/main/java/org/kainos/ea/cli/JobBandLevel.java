package org.kainos.ea.cli;

public class JobBandLevel {
    private int jobRoleId;
    private String jobRoleName;
    private String jobFamilyGroupName;
    private String jobBandLevel;

    public JobBandLevel(){
        // Default
    }


    public JobBandLevel(int jobRoleId, String jobRoleName, String jobFamilyGroupName, String jobBandLevel) {
        this.jobRoleId = jobRoleId;
        this.jobRoleName = jobRoleName;
        this.jobFamilyGroupName = jobFamilyGroupName;
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
}
