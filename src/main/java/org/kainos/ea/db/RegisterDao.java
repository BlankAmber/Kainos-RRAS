package org.kainos.ea.db;

import com.password4j.Hash;
import com.password4j.Password;
import org.kainos.ea.cli.Login;
import org.kainos.ea.cli.RegisterDetails;
import org.kainos.ea.util.DaoUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDao {
    public static final int PASSWORD_SALT_LENGTH = 12;

    public boolean doesEmailExist(Connection conn, String email) throws SQLException {
        String statement = "SELECT * FROM user WHERE email = ?";
        ResultSet resultSet = DaoUtil.executeStatement(conn, statement, true, email);
        return resultSet.next();
    }

    public void register(Connection conn, RegisterDetails registerDetails) throws SQLException {
        String statement = "INSERT INTO user (email, secured_password, role_id) VALUES (?,?,?)";

        Hash hash = Password.hash(registerDetails.getPassword())
                .addRandomSalt(PASSWORD_SALT_LENGTH)
                .withArgon2();
        String password = hash.getResult();

        DaoUtil.executeStatement(conn, statement, false,
                registerDetails.getEmail(), password, registerDetails.getRoleId());
    }
}
