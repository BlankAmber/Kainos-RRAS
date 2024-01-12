package org.kainos.ea.client;

public class JobResponsibilitiesLengthException extends Exception {
    @Override
    public String getMessage() {
        return "Job responsibilities length too long";
    }
}
