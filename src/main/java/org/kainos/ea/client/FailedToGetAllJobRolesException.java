package org.kainos.ea.client;

public class FailedToGetAllJobRolesException extends Exception {
    public String getMessage() {
        return "Failed to get all of the job roles";
    }
}
