package org.kainos.ea.db;

import com.password4j.Password;
import org.apache.commons.lang3.time.DateUtils;
import org.kainos.ea.cli.Login;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class AuthDao {
    private static final int TOKEN_EXPIRY_NUM_HOURS_AFTER_LOGIN = 8;

    public boolean isValidLogin(Login login, Connection conn) throws SQLException {
        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery(
                "SELECT secured_password FROM user WHERE email = "
                + "'" + login.getEmail() + "'");

        if (resultSet.next()) {
            String securedPassword = resultSet.getString("secured_password");
            return Password.check(login.getPassword(), securedPassword).withArgon2();
        }

        return false;
    }

    public String generateToken(String email, Connection conn) throws SQLException {
        String token = UUID.randomUUID().toString();
        // TODO: Test this with different timezones
        Date expiryDate = DateUtils.addHours(new Date(), TOKEN_EXPIRY_NUM_HOURS_AFTER_LOGIN);

        String insertStatement = "INSERT INTO token (email, token, expiry_date) VALUES (?,?,?)";

        PreparedStatement statement = conn.prepareStatement(insertStatement);
        DaoUtil.populatePreparedStatement(statement,
                email,
                token,
                new Timestamp(expiryDate.getTime())
        );
        statement.executeUpdate();

        return token;
    }
}
