package org.kainos.ea.client;

public class FailedToGetJobRoleException extends Exception {
    public String getMessage() {
        return "Failed to get a job role";
    }
}
