package org.kainos.ea.client;

public class JobRoleLinkLengthException extends Throwable{
    @Override
    public String getMessage()
    {
        return "Job role link length too long";
    }
}
