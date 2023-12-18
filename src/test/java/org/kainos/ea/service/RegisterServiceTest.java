package org.kainos.ea.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.kainos.ea.api.RegisterService;
import org.kainos.ea.cli.Login;
import org.kainos.ea.client.*;
import org.kainos.ea.core.RegisterValidator;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.RegisterDao;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterServiceTest {
    private final RegisterDao registerDao = Mockito.mock(RegisterDao.class);;
    private final DatabaseConnector databaseConnector = Mockito.mock(DatabaseConnector.class);
    private final RegisterValidator registerValidator = Mockito.mock(RegisterValidator.class);
    private final Connection conn = Mockito.mock(Connection.class);

    private final RegisterService registerService
            = new RegisterService(registerDao, databaseConnector, registerValidator);

    private final Login login = new Login("AdminTest", "Password%");

    @Test
    @DisplayName("Test valid register")
    void register_withValidDetails_shouldNotThrowAnException()
            throws SQLException {
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(registerDao.doesEmailExist(conn, login.getEmail())).thenReturn(false);
        Mockito.when(registerValidator.validateLogin(login))
                .thenReturn(RegisterValidator.ValidationResult.VALID);

        assertDoesNotThrow(() -> registerService.register(login));
    }

    @Test
    @DisplayName("Test register with email that already exists")
    void register_withDuplicateEmail_shouldThrowRegisterEmailAlreadyExistsException()
            throws SQLException {
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(registerDao.doesEmailExist(conn, login.getEmail())).thenReturn(true);

        assertThrows(RegisterEmailAlreadyExistsException.class, () -> registerService.register(login));
    }

    @Test
    @DisplayName("Test register with email in invalid format")
    void register_withInvalidFormatEmail_shouldThrowInvalidRegisterException()
        throws SQLException {
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(registerDao.doesEmailExist(conn, login.getEmail())).thenReturn(false);
        Mockito.when(registerValidator.validateLogin(login))
                .thenReturn(RegisterValidator.ValidationResult.EMAIL_INCORRECT_FORMAT);

        assertThrows(InvalidRegisterException.class, () -> registerService.register(login));
    }

    @Test
    @DisplayName("Test register with short password")
    void register_withShortPassword_shouldThrowInvalidRegisterException()
            throws SQLException {
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(registerDao.doesEmailExist(conn, login.getEmail())).thenReturn(false);
        Mockito.when(registerValidator.validateLogin(login))
                .thenReturn(RegisterValidator.ValidationResult.PASSWORD_TOO_SHORT);

        assertThrows(InvalidRegisterException.class, () -> registerService.register(login));
    }
}
