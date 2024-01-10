package org.kainos.ea.client;

public class JobRoleLinkLengthException extends Exception {
    @Override
    public String getMessage() {
        return "Job role link length too long";
    }
}
