package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JobBandLevel {
    private int jobBandLevelId;
    private String jobBandLevel;

    @JsonCreator
    public JobBandLevel(
            @JsonProperty("jobBandLevelId") int jobBandLevelId,
            @JsonProperty("jobBandLevel") String jobBandLevel) {
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
