package org.kainos.ea.cli;

public class JobBandLevel {
    private int jobBandLevelId;
    private String jobBandLevel;

    public JobBandLevel(){
        // Default
    }


    public JobBandLevel(int jobBandLevelId, String jobBandLevel) {
        this.jobBandLevelId = jobBandLevelId;
        this.jobBandLevel = jobBandLevel;
    }

    public int getJobBandLevelId() {
        return jobBandLevelId;
    }

    public void setJobBandLevelId(int jobBandLevelId) {
        this.jobBandLevelId = jobBandLevelId;
    }

    public String getJobBandLevel() {
        return jobBandLevel;
    }

    public void setJobBandLevel(String jobBandLevel) {
        this.jobBandLevel = jobBandLevel;
    }
}
