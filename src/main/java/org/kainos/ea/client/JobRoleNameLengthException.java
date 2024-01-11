package org.kainos.ea.client;

public class JobRoleNameLengthException extends Exception {
    @Override
    public String getMessage() {
        return "Job role name length too long";
    }
}
