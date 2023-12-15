package org.kainos.ea.db;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    public static ResultSet executeStatement(
            Connection conn, String statement, boolean isQuery, Object... values)
            throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement(statement,
                Statement.RETURN_GENERATED_KEYS);
        DaoUtil.populatePreparedStatement(preparedStatement, values);
        if (isQuery) {
            return preparedStatement.executeQuery();
        }
        return preparedStatement.getGeneratedKeys();
    }

    public static DecodedJWT decodeJWT(String jwt) throws JWTVerificationException {
        Algorithm algorithm = Algorithm.HMAC256(System.getenv("JWT_SECRET"));
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .build();
        return verifier.verify(jwt);
    }
}
