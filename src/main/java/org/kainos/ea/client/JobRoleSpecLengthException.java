package org.kainos.ea.client;

public class JobRoleSpecLengthException extends Throwable{
    @Override
    public String getMessage()
    {
        return "Job role specification length too long";
    }
}
