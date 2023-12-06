package org.kainos.ea.client;

public class FailedToLoginException extends Exception {
    public String getMessage() {
        return "Failed to login";
    }
}
