package org.kainos.ea.api;

import org.kainos.ea.cli.Login;
import org.kainos.ea.client.FailedToRegisterException;
import org.kainos.ea.client.InvalidRegisterException;
import org.kainos.ea.client.RegisterEmailAlreadyExistsException;
import org.kainos.ea.core.RegisterValidator;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.RegisterDao;

import java.sql.Connection;
import java.sql.SQLException;

public class RegisterService {
    private final RegisterDao registerDao;
    private final DatabaseConnector databaseConnector;
    private final RegisterValidator registerValidator;

    public RegisterService(
            RegisterDao registerDao, DatabaseConnector databaseConnector,
            RegisterValidator registerValidator) {
        this.registerDao = registerDao;
        this.databaseConnector = databaseConnector;
        this.registerValidator = registerValidator;
    }

    public void register(Login login)
            throws RegisterEmailAlreadyExistsException, InvalidRegisterException,
            FailedToRegisterException {
        try {
            Connection conn = databaseConnector.getConnection();
            if (registerDao.doesEmailExist(conn, login.getEmail())) {
                throw new RegisterEmailAlreadyExistsException();
            }

            RegisterValidator.ValidationResult result = registerValidator.validateLogin(login);
            if (result == RegisterValidator.ValidationResult.VALID) {
                registerDao.register(conn, login);
                return;
            }

            throw new InvalidRegisterException(result);
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToRegisterException();
        }
    }
}
