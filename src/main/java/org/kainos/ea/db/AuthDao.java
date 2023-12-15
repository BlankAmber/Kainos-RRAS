package org.kainos.ea.db;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.password4j.Password;
import org.apache.commons.lang3.time.DateUtils;
import org.kainos.ea.cli.Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

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

    public String generateJWT(String email) throws SQLException {
        // TODO: Test this with different timezones
        Date expiryDate = DateUtils.addHours(new Date(), TOKEN_EXPIRY_NUM_HOURS_AFTER_LOGIN);

        Algorithm algorithm = Algorithm.HMAC256(System.getenv("JWT_SECRET"));
        return JWT.create()
                .withIssuer("auth0")
                .withSubject(email)
                .withExpiresAt(expiryDate)
                .sign(algorithm);
    }
}
