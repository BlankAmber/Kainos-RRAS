package org.kainos.ea.client;

public class FailedToVerifyTokenException extends Exception {
    @Override
    public String getMessage() {
        return "Failed to verify token";
    }
}
