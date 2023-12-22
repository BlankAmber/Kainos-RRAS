package org.kainos.ea.client;

public class JobResponsibilitiesLengthException extends Throwable{
    @Override
    public String getMessage()
    {
        return "Job responsibilities length too long";
    }
}
