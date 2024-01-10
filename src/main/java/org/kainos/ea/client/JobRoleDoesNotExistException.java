package org.kainos.ea.client;

public class JobRoleDoesNotExistException extends Exception {
    public String getMessage() {
        return "Job role does not exist";
    }
}
