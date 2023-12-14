package org.kainos.ea.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class DaoUtil {
    private DaoUtil() {

    }

    public static void populatePreparedStatement(
            PreparedStatement preparedStatement, Object... values)
            throws SQLException {
        for (int i = 0; i < values.length; i++) {
            preparedStatement.setObject(i + 1, values[i]);
        }
    }
}
