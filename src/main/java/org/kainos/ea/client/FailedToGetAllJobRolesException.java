package org.kainos.ea.client;

public class FailedToGetAllJobRolesException extends Exception {
    public String getMessage() {
        return "Failed to select all of the job roles";
    }
}
