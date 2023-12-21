package org.kainos.ea.client;

public class FailedToCreateJobRoleException extends Throwable{
    public String getMessage() {
        return "Failed to create new role";
    }
}
