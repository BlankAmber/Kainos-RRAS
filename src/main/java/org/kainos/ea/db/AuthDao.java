package org.kainos.ea.db;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.password4j.Password;
import org.apache.commons.lang3.time.DateUtils;
import org.kainos.ea.cli.Login;
import org.kainos.ea.util.DaoUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class AuthDao {
    private static final int TOKEN_EXPIRY_NUM_HOURS_AFTER_LOGIN = 8;

    public boolean ping(Connection conn) {
        String statement = "SELECT 1";
        try {
            DaoUtil.executeStatement(conn, statement, true);
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean isValidLogin(Connection conn, Login login) throws SQLException {
        String statement = "SELECT secured_password FROM user WHERE email = ?";
        ResultSet resultSet =
                DaoUtil.executeStatement(conn, statement, true, login.getEmail());

        if (resultSet.next()) {
            String securedPassword = resultSet.getString("secured_password");
            return Password.check(login.getPassword(), securedPassword).withArgon2();
        }

        return false;
    }

    public String generateJWT(Connection conn, String email) throws SQLException {
        String statement = "SELECT role_id FROM user WHERE email = ?";
        ResultSet resultSet = DaoUtil.executeStatement(conn, statement, true, email);

        int roleId;
        if (resultSet.next()) {
            roleId = resultSet.getInt("role_id");
        } else {
            return null;
        }

        // TODO: Test this with different timezones
        Date expiryDate = DateUtils.addHours(new Date(), TOKEN_EXPIRY_NUM_HOURS_AFTER_LOGIN);

        Algorithm algorithm = Algorithm.HMAC256(System.getenv("JWT_SECRET"));
        return JWT.create()
                .withIssuer("auth0")
                .withSubject(email)
                .withExpiresAt(expiryDate)
                .withClaim("role_id", roleId)
                .sign(algorithm);
    }
}
