package org.kainos.ea.db;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabasePropertiesTest {
    @Test
    @DisplayName("Test for constructor and getters")
    void constructorAndGetters() {
        String expectedUsername = "TestUser";
        String expectedPassword = "TestPassword";
        String expectedHost = "TestHost";
        String expectedName = "TestName";
        DatabaseProperties props = new DatabaseProperties(
                expectedUsername,
                expectedPassword,
                expectedHost,
                expectedName
        );
        assertEquals(expectedUsername, props.getUsername());
        assertEquals(expectedPassword, props.getPassword());
        assertEquals(expectedHost, props.getHost());
        assertEquals(expectedName, props.getName());
    }

    @Test
    @DisplayName("Test for isValid() with valid input")
    void isValid_withValidProperties_shouldReturnTrue() {
        DatabaseProperties props = new DatabaseProperties(
                "user", "password", "host", "name");
        assertTrue(props.isValid());
    }

    @Test
    @DisplayName("Test for isValid() with the user null")
    void isValid_withNullUsername_shouldReturnFalse() {
        DatabaseProperties props = new DatabaseProperties(
                null, "password", "host", "name");
        assertFalse(props.isValid());
    }

    @Test
    @DisplayName("Test for isValid() with the password null")
    void isValid_withNullPassword_shouldReturnFalse() {
        DatabaseProperties props = new DatabaseProperties(
                "user", null, "host", "name");
        assertFalse(props.isValid());
    }

    @Test
    @DisplayName("Test for isValid() with the host null")
    void isValid_withNullHost_shouldReturnFalse() {
        DatabaseProperties props = new DatabaseProperties(
                "user", "password", null, "name");
        assertFalse(props.isValid());
    }

    @Test
    @DisplayName("Test for isValid() with the name null")
    void isValid_withNullName_shouldReturnFalse() {
        DatabaseProperties props = new DatabaseProperties(
                "user", "password", "host", null);
        assertFalse(props.isValid());
    }
}
