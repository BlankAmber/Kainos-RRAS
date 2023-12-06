package org.kainos.ea.db;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DatabaseConnectorTest {
    @Test
    @DisplayName("Test valid SQL connection")
    void testSQLConnectionValid() throws SQLException {
        Connection connection = DatabaseConnector.getConnection();
        assertNotNull(connection);
        assertFalse(connection.isClosed());
    }

    @Test
    @DisplayName("Test invalid SQL connection")
    void testSQLConnectionInvalid() {
        DatabaseProperties props = new DatabaseProperties(
                "user", "password", "host", "name");
        assertThrows(CommunicationsException.class, () -> {
            DatabaseConnector.getConnection(props);
        });
    }
}
