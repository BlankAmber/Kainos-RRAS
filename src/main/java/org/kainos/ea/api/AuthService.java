package org.kainos.ea.api;

import org.kainos.ea.cli.Login;
import org.kainos.ea.client.FailedToGenerateTokenException;
import org.kainos.ea.client.FailedToLoginException;
import org.kainos.ea.client.FailedToValidateLoginException;
import org.kainos.ea.db.AuthDao;
import org.kainos.ea.db.DatabaseConnector;

import java.sql.SQLException;

public class AuthService {
    private final AuthDao authDao;
    private final DatabaseConnector databaseConnector;

    public AuthService(AuthDao authDao, DatabaseConnector databaseConnector) {
        this.authDao = authDao;
        this.databaseConnector = databaseConnector;
    }

    public String login(Login login)
            throws FailedToGenerateTokenException,
            FailedToValidateLoginException, FailedToLoginException {
        try {
            if (authDao.isValidLogin(login, databaseConnector.getConnection())) {
                try {
                    return authDao.generateToken(login.getUsername(),
                            databaseConnector.getConnection());
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                    throw new FailedToGenerateTokenException();
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToValidateLoginException();
        }

        throw new FailedToLoginException();
    }
}
