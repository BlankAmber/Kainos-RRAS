package org.kainos.ea.client;

public class JobBandLevelIdException extends Throwable{
    @Override
    public String getMessage()
    {
        return "Invalid job band level";
    }
}
