package org.kainos.ea.db;

public enum RoleID {
    ADMIN(1),
    EMPLOYEE(2);

    private final int dbValue;

    RoleID(int dbValue) {
        this.dbValue = dbValue;
    }

    public int getDBValue() {
        return this.dbValue;
    }
}
