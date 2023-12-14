package org.kainos.ea.client;

public class JobRoleDoesNotExistException extends Throwable{
    public String getMessage() {
        return "Failed to get  the job roles";
    }
}
