package org.kainos.ea.client;

public class FailedToDeleteJobRoleException extends Exception {
    public String getMessage() {
        return "Failed to delete job role";
    }
}
