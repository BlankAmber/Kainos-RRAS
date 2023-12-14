package org.kainos.ea.db;

import org.apache.commons.lang3.time.DateUtils;
import org.kainos.ea.cli.Login;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
                "SELECT salt, secured_password FROM user WHERE username = "
                + "'" + login.getUsername() + "'");

        if (resultSet.next()) {
            String salt = resultSet.getString("salt");
            String saltedPassword = login.getPassword() + salt;

            MessageDigest messageDigest = null;
            try {
                messageDigest = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e) {
                System.err.println("Algorithm not found!");
            }

            byte[] encodedHash = messageDigest.digest(saltedPassword.getBytes());
            String securedPassword = String.format("%064x", new BigInteger(1, encodedHash));

            return resultSet.getString("secured_password").equals(securedPassword);
        }

        return false;
    }

    public String generateToken(String username, Connection conn) throws SQLException {
        String token = UUID.randomUUID().toString();
        // TODO: Test this with different timezones
        Date expiryDate = DateUtils.addHours(new Date(), TOKEN_EXPIRY_NUM_HOURS_AFTER_LOGIN);

        String insertStatement = "INSERT INTO token (username, token, expiry_date) VALUES (?,?,?)";

        PreparedStatement statement = conn.prepareStatement(insertStatement);
        DaoUtil.populatePreparedStatement(statement,
                username,
                token,
                new Timestamp(expiryDate.getTime())
        );
        statement.executeUpdate();

        return token;
    }
}
