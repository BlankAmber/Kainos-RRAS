package org.kainos.ea.cli;

public class JobFamilyGroup {

    private int jobFamilyGroupId;

    private String jobFamilyGroupName;


    public JobFamilyGroup(int jobFamilyGroupId, String jobFamilyGroupName) {
        this.jobFamilyGroupId = jobFamilyGroupId;
        this.jobFamilyGroupName = jobFamilyGroupName;
    }

    public int getJobFamilyGroupId() {
        return jobFamilyGroupId;
    }

    public void setJobFamilyGroupId(int jobFamilyGroupId) {
        this.jobFamilyGroupId = jobFamilyGroupId;
    }

    public String getJobFamilyGroupName() {
        return jobFamilyGroupName;
    }

    public void setJobFamilyGroupName(String jobFamilyGroupName) {
        this.jobFamilyGroupName = jobFamilyGroupName;
    }
}
