package org.kainos.ea.client;

public class FailedToGetAllFamilyGroupsException extends Exception {
    public String getMessage() {
        return "Failed to select all of the Family Groups";
    }
}
