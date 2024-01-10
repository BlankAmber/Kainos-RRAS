package org.kainos.ea.client;

public class InvalidJobRoleException extends Exception {
    public InvalidJobRoleException(String validation) {
        super(validation);
    }
}
