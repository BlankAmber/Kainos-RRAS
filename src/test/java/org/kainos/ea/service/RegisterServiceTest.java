package org.kainos.ea.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.kainos.ea.api.RegisterService;
import org.kainos.ea.cli.RegisterDetails;
import org.kainos.ea.client.InvalidRegisterException;
import org.kainos.ea.client.RegisterEmailAlreadyExistsException;
import org.kainos.ea.core.RegisterValidator;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.RegisterDao;
import org.kainos.ea.db.RoleID;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RegisterServiceTest {
    private final RegisterDao registerDao = Mockito.mock(RegisterDao.class);;
    private final DatabaseConnector databaseConnector = Mockito.mock(DatabaseConnector.class);
    private final RegisterValidator registerValidator = Mockito.mock(RegisterValidator.class);
    private final Connection conn = Mockito.mock(Connection.class);

    private final RegisterService registerService
            = new RegisterService(registerDao, databaseConnector, registerValidator);

    private final RegisterDetails registerDetails = new RegisterDetails(
            "AdminTest", "Password%", RoleID.ADMIN.getDBValue());

    @Test
    @DisplayName("Test valid register")
    void register_withValidDetails_shouldNotThrowAnException()
            throws SQLException {
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(registerDao.doesEmailExist(conn, registerDetails.getEmail()))
                .thenReturn(false);
        Mockito.when(registerValidator.validateRegisterDetails(registerDetails))
                .thenReturn(RegisterValidator.ValidationResult.VALID);

        assertDoesNotThrow(() -> registerService.register(registerDetails));
    }

    @Test
    @DisplayName("Test register with email that already exists")
    void register_withDuplicateEmail_shouldThrowRegisterEmailAlreadyExistsException()
            throws SQLException {
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(registerDao.doesEmailExist(conn, registerDetails.getEmail()))
                .thenReturn(true);

        assertThrows(RegisterEmailAlreadyExistsException.class,
                () -> registerService.register(registerDetails));
    }

    @Test
    @DisplayName("Test register with email in invalid format")
    void register_withInvalidFormatEmail_shouldThrowInvalidRegisterException()
        throws SQLException {
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(registerDao.doesEmailExist(conn, registerDetails.getEmail()))
                .thenReturn(false);
        Mockito.when(registerValidator.validateRegisterDetails(registerDetails))
                .thenReturn(RegisterValidator.ValidationResult.EMAIL_INCORRECT_FORMAT);

        assertThrows(InvalidRegisterException.class,
                () -> registerService.register(registerDetails));
    }

    @Test
    @DisplayName("Test register with short password")
    void register_withShortPassword_shouldThrowInvalidRegisterException()
            throws SQLException {
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(registerDao.doesEmailExist(conn, registerDetails.getEmail()))
                .thenReturn(false);
        Mockito.when(registerValidator.validateRegisterDetails(registerDetails))
                .thenReturn(RegisterValidator.ValidationResult.PASSWORD_TOO_SHORT);

        assertThrows(InvalidRegisterException.class,
                () -> registerService.register(registerDetails));
    }

    @Test
    @DisplayName("Test register with invalid role ID")
    void register_withInvalidRoleID_shouldThrowInvalidRegisterException()
            throws SQLException {
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(registerDao.doesEmailExist(conn, registerDetails.getEmail()))
                .thenReturn(false);
        Mockito.when(registerValidator.validateRegisterDetails(registerDetails))
                .thenReturn(RegisterValidator.ValidationResult.INVALID_ROLE_ID);

        assertThrows(InvalidRegisterException.class,
                () -> registerService.register(registerDetails));
    }
}
