package org.kainos.ea.client;

public class JWTExpiredException extends Exception {
    public String getMessage() {
        return "JWT has expired";
    }
}
