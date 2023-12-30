package org.kainos.ea.client;

public class FailedToValidateLoginException extends Exception {
    public String getMessage() {
        return "Failed to validate login";
    }
}
