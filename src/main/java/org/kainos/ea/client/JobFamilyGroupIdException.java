package org.kainos.ea.client;

public class JobFamilyGroupIdException extends Throwable{
    @Override
    public String getMessage()
    {
        return "Invalid job family group";
    }
}
