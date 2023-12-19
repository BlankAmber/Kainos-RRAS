package org.kainos.ea.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.kainos.ea.api.AuthService;
import org.kainos.ea.cli.Login;
import org.kainos.ea.client.FailedToGenerateTokenException;
import org.kainos.ea.client.FailedToLoginException;
import org.kainos.ea.client.FailedToValidateLoginException;
import org.kainos.ea.db.AuthDao;
import org.kainos.ea.db.DatabaseConnector;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AuthServiceTest {
    private final AuthDao authDao = Mockito.mock(AuthDao.class);;
    private final DatabaseConnector databaseConnector = Mockito.mock(DatabaseConnector.class);
    private final Connection conn = Mockito.mock(Connection.class);

    private final AuthService authService = new AuthService(authDao, databaseConnector);

    private final Login login = new Login("AdminTest", "Password%");

    @Test
    @DisplayName("Test valid login")
    void login_whenDaoIsValidLoginReturnsTrue_shouldReturnToken()
            throws SQLException,
            FailedToGenerateTokenException,
            FailedToValidateLoginException, FailedToLoginException {
        String expectedToken = "token";

        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(authDao.isValidLogin(conn, login)).thenReturn(true);
        Mockito.when(authDao.generateJWT(conn, login.getEmail())).thenReturn(expectedToken);

        assertEquals(expectedToken, authService.login(login));
    }

    @Test
    @DisplayName("Test invalid login")
    void login_whenDaoIsValidLoginReturnsFalse_shouldThrowFailedToLoginException()
            throws SQLException {
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(authDao.isValidLogin(conn, login)).thenReturn(false);

        assertThrows(FailedToLoginException.class,
                () -> authService.login(login));
    }

    @Test
    @DisplayName("Test login FailedToGenerateToken exception")
    void login_whenDaoGenerateTokenThrowsSQLException_shouldThrowFailedToGenerateTokenException()
            throws SQLException {
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(authDao.isValidLogin(conn, login)).thenReturn(true);
        Mockito.when(authDao.generateJWT(conn, login.getEmail()))
                .thenThrow(SQLException.class);

        assertThrows(FailedToGenerateTokenException.class, () -> authService.login(login));
    }

    @Test
    @DisplayName("Test login FailedToValidateLogin exception")
    void login_whenDaoIsValidLoginThrowsSQLException_shouldThrowFailedToValidateLoginException()
            throws SQLException {
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(authDao.isValidLogin(conn, login)).thenThrow(SQLException.class);

        assertThrows(FailedToValidateLoginException.class, () -> authService.login(login));
    }
}
