package org.kainos.ea.api;

import org.kainos.ea.cli.Login;
import org.kainos.ea.client.FailedToGenerateTokenException;
import org.kainos.ea.client.FailedToLoginException;
import org.kainos.ea.db.AuthDao;

import java.sql.SQLException;

public class AuthService {
    private final AuthDao authDao = new AuthDao();

    public String login(Login login) throws FailedToLoginException, FailedToGenerateTokenException {
        if (authDao.isValidLogin(login)) {
            try {
                return authDao.generateToken(login.getUsername());
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                throw new FailedToGenerateTokenException();
            }
        }

        throw new FailedToLoginException();
    }
}
