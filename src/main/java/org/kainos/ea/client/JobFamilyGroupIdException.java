package org.kainos.ea.client;

public class JobFamilyGroupIdException extends Exception {
    @Override
    public String getMessage() {
        return "Invalid job family group";
    }
}
