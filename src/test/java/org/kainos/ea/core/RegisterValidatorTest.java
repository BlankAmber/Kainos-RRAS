package org.kainos.ea.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterValidatorTest {
    private final RegisterValidator registerValidator = new RegisterValidator();

    @Test
    @DisplayName("Test validate email with valid email")
    void validateEmail_withValidEmail_shouldReturnValid() {
        RegisterValidator.ValidationResult result =
                registerValidator.validateEmail("Example@email.com");
        assertEquals(RegisterValidator.ValidationResult.VALID, result);
    }

    @Test
    @DisplayName("Test validate email with invalid email")
    void validateEmail_withInvalidEmail_shouldReturnIncorrectFormat() {
        String[] emails = {
                "OhDearItsAHyphen@email.co-m",
                "",
                "ThisIsNotEvenRemotelyCorrect",
                "Spaces Are Cool@email.com",
                "WhatIsAnAtSymbol.com",
                "We@love.punctuation!",
        };
        for (String email : emails) {
            RegisterValidator.ValidationResult result = registerValidator.validateEmail(email);
            assertEquals(RegisterValidator.ValidationResult.EMAIL_INCORRECT_FORMAT, result);
        }
    }

    @Test
    @DisplayName("Test validate password with valid password")
    void validatePassword_withValidPassword_shouldReturnValid() {
        RegisterValidator.ValidationResult result = registerValidator.validatePassword("Password!");
        assertEquals(RegisterValidator.ValidationResult.VALID, result);
    }

    @Test
    @DisplayName("Test validate password with short password")
    void validatePassword_withShortPassword_shouldReturnPasswordTooShort() {
        RegisterValidator.ValidationResult result = registerValidator.validatePassword("Pa!");
        assertEquals(RegisterValidator.ValidationResult.PASSWORD_TOO_SHORT, result);
    }

    @Test
    @DisplayName("Test validate password with lowercase password")
    void validatePassword_withLowercasePassword_shouldReturnPasswordNoUppercase() {
        RegisterValidator.ValidationResult result = registerValidator.validatePassword("password!");
        assertEquals(RegisterValidator.ValidationResult.PASSWORD_NO_UPPERCASE_CHARACTERS, result);
    }

    @Test
    @DisplayName("Test validate password with uppercase password")
    void validatePassword_withUppercasePassword_shouldReturnPasswordNoLowercase() {
        RegisterValidator.ValidationResult result = registerValidator.validatePassword("PASSWORD!");
        assertEquals(RegisterValidator.ValidationResult.PASSWORD_NO_LOWERCASE_CHARACTERS, result);
    }

    @Test
    @DisplayName("Test validate password with no symbols")
    void validatePassword_withNoSymbols_shouldReturnPasswordNoSymbols() {
        RegisterValidator.ValidationResult result = registerValidator.validatePassword("Password");
        assertEquals(RegisterValidator.ValidationResult.PASSWORD_NO_SYMBOLS, result);
    }
}
