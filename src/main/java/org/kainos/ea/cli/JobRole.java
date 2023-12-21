package org.kainos.ea.cli;

<<<<<<< HEAD

public class JobRole {

    private int jobRoleId;
    private String jobRoleName;

    private String jobRoleSpec;
    private String jobRoleLink;

    public JobRole() {
        // Default constructor
    }


    public JobRole(int jobRoleId, String jobRoleName, String jobRoleSpec, String jobRoleLink) {
        this.jobRoleId = jobRoleId;
        this.jobRoleName = jobRoleName;
        this.jobRoleSpec = jobRoleSpec;
        this.jobRoleLink = jobRoleLink;

=======
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JobRole {
    private int jobRoleId;
    private String jobRoleName;

    @JsonCreator
    public JobRole(
            @JsonProperty("jobRoleId") int jobRoleId,
            @JsonProperty("jobRoleName") String jobRoleName) {
        this.jobRoleId = jobRoleId;
        this.jobRoleName = jobRoleName;
>>>>>>> ready-for-signoff
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
<<<<<<< HEAD

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
=======
>>>>>>> ready-for-signoff
}
