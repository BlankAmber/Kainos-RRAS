package org.kainos.ea;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class Util {
    private Util() {

    }

    public static void setValues(PreparedStatement preparedStatement, Object... values)
            throws SQLException {
        for (int i = 0; i < values.length; i++) {
            preparedStatement.setObject(i + 1, values[i]);
        }
    }
}
