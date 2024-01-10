package org.kainos.ea.client;

public class RegisterEmailAlreadyExistsException extends Exception {
    public String getMessage() {
        return "Email already exists";
    }
}
