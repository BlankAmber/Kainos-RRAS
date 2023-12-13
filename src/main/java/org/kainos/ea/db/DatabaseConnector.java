package org.kainos.ea.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    public static final String ENV_DB_USERNAME = "DB_USERNAME";
    public static final String ENV_DB_PASSWORD = "DB_PASSWORD";
    public static final String ENV_DB_HOST = "DB_HOST";
    public static final String ENV_DB_NAME = "DB_NAME";

    private static Connection connection;

    public static void resetConnection() {
        DatabaseConnector.connection = null;
    }

    public DatabaseConnector() {

    }

    public static DatabaseProperties getDatabaseProperties() {
        String user = System.getenv(ENV_DB_USERNAME);
        String password = System.getenv(ENV_DB_PASSWORD);
        String host = System.getenv(ENV_DB_HOST);
        String name = System.getenv(ENV_DB_NAME);

        return new DatabaseProperties(user, password, host, name);
    }

    public static Connection getConnection(DatabaseProperties props)
            throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://" + props.getHost() + "/" + props.getName()
                        + "?useSSL=false",
                props.getUsername(), props.getPassword());
    }

    public Connection getConnection()
            throws SQLException {
        if (DatabaseConnector.connection != null
                && !DatabaseConnector.connection.isClosed()) {
            return DatabaseConnector.connection;
        }

        try {
            DatabaseProperties props = getDatabaseProperties();

            if (!props.isValid()) {
                throw new IllegalArgumentException(
                        "Environment variables must be set for "
                        + "DB_USERNAME, DB_PASSWORD, DB_HOST, and DB_NAME."
                );
            }

            DatabaseConnector.connection = getConnection(props);
            return DatabaseConnector.connection;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return null;
    }
}
