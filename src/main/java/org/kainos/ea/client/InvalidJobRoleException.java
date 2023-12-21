package org.kainos.ea.client;

public class InvalidJobRoleException extends Throwable{
    public InvalidJobRoleException(String validation) {
        super(validation);}
}
