package org.kainos.ea.client;

public class FailedToGetAllBandLevelsException extends Throwable{
    public String getMessage() {
        return "Failed to select all of the Family Groups";
    }
}
