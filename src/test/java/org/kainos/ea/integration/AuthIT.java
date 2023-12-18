package org.kainos.ea.integration;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.DropwizardWebServiceApplication;
import org.kainos.ea.DropwizardWebServiceConfiguration;
import org.kainos.ea.cli.Login;
import org.kainos.ea.db.RoleID;
import org.kainos.ea.util.JWTUtil;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(DropwizardExtensionsSupport.class)
public class AuthIT {
    static final DropwizardAppExtension<DropwizardWebServiceConfiguration> APP
            = new DropwizardAppExtension<>(
                    DropwizardWebServiceApplication.class, null,
            new ResourceConfigurationSourceProvider()
    );

    @Test
    @DisplayName("Test valid login to an admin account")
    void postLogin_withValidAdminAccount_shouldReturnToken() {
        String email = System.getenv("TEST_ADMIN_ACCOUNT_EMAIL");
        String password = System.getenv("TEST_ADMIN_ACCOUNT_PASSWORD");
        Login login = new Login(email, password);

        String jwt = APP.client().target("http://localhost:8080/api/login")
                .request()
                .post(Entity.entity(login, MediaType.APPLICATION_JSON_TYPE))
                .readEntity(String.class);

        DecodedJWT decodedJWT;
        try {
            decodedJWT = JWTUtil.decodeJWT(jwt);
        } catch (JWTVerificationException e) {
            fail();
            return;
        }
        assertEquals(email, decodedJWT.getSubject());
        assertEquals(RoleID.ADMIN, JWTUtil.getRoleIdFromDecodedJWT(decodedJWT));
    }

    @Test
    @DisplayName("Test valid login to an employee account")
    void postLogin_withValidEmployeeAccount_shouldReturnToken() {
        String email = System.getenv("TEST_EMPLOYEE_ACCOUNT_EMAIL");
        String password = System.getenv("TEST_EMPLOYEE_ACCOUNT_PASSWORD");
        Login login = new Login(email, password);

        String jwt = APP.client().target("http://localhost:8080/api/login")
                .request()
                .post(Entity.entity(login, MediaType.APPLICATION_JSON_TYPE))
                .readEntity(String.class);

        DecodedJWT decodedJWT;
        try {
            decodedJWT = JWTUtil.decodeJWT(jwt);
        } catch (JWTVerificationException e) {
            fail();
            return;
        }
        assertEquals(email, decodedJWT.getSubject());
        assertEquals(RoleID.EMPLOYEE, JWTUtil.getRoleIdFromDecodedJWT(decodedJWT));
    }

    @Test
    @DisplayName("Test login invalid password to an admin account")
    void postLogin_withInvalidPasswordForAdminAccount_shouldReturnBadRequestError() {
        Login login = new Login(
                System.getenv("TEST_ADMIN_ACCOUNT_EMAIL"),
                "TestPassword"
        );

        Response response = APP.client().target("http://localhost:8080/api/login")
                .request()
                .post(Entity.entity(login, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }

    @Test
    @DisplayName("Test login invalid password to an employee account")
    void postLogin_withInvalidPasswordForEmployeeAccount_shouldReturnBadRequestError() {
        Login login = new Login(
                System.getenv("TEST_EMPLOYEE_ACCOUNT_EMAIL"),
                "TestPassword"
        );

        Response response = APP.client().target("http://localhost:8080/api/login")
                .request()
                .post(Entity.entity(login, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }

    @Test
    @DisplayName("Test login invalid account info")
    void postLogin_withInvalidAccountInfo_shouldReturnBadRequestError() {
        Login login = new Login(
                "NotARealEmail",
                "NotARealPassword"
        );

        Response response = APP.client().target("http://localhost:8080/api/login")
                .request()
                .post(Entity.entity(login, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }
}
