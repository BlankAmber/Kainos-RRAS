package org.kainos.ea.client;

public class DatabaseConnectionException extends Throwable{
    public String getMessage() {
        return "Error with database connection";
    }
}
