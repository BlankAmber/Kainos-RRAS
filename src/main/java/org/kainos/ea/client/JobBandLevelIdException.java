package org.kainos.ea.client;

public class JobBandLevelIdException extends Exception {
    @Override
    public String getMessage() {
        return "Invalid job band level";
    }
}
