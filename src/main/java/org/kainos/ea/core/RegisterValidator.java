package org.kainos.ea.core;

import org.kainos.ea.cli.Login;
import org.kainos.ea.cli.RegisterDetails;
import org.kainos.ea.db.RoleID;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterValidator {
    public static final int MIN_PASSWORD_LENGTH = 8;

    public enum ValidationResult {
        VALID,
        EMAIL_INCORRECT_FORMAT,
        PASSWORD_TOO_SHORT,
        PASSWORD_NO_UPPERCASE_CHARACTERS,
        PASSWORD_NO_LOWERCASE_CHARACTERS,
        PASSWORD_NO_SYMBOLS,
        INVALID_ROLE_ID
    }

    public ValidationResult validateEmail(String email) {
        String pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9._%+-]+\\.[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(pattern);
        Matcher match = regex.matcher(email);
        if (match.matches()) {
            return ValidationResult.VALID;
        }
        return ValidationResult.EMAIL_INCORRECT_FORMAT;
    }

    public ValidationResult validatePassword(String password) {
        if (password.length() < MIN_PASSWORD_LENGTH) {
            return ValidationResult.PASSWORD_TOO_SHORT;
        }

        if (!Pattern.compile("[A-Z]").matcher(password).find()) {
            return ValidationResult.PASSWORD_NO_UPPERCASE_CHARACTERS;
        }

        if (!Pattern.compile("[a-z]").matcher(password).find()) {
            return ValidationResult.PASSWORD_NO_LOWERCASE_CHARACTERS;
        }

        String symbolsPattern = "[!@£$%^&*()#,./\\\\;:'\"\\-_+=\\[\\]{}|`~]";
        if (!Pattern.compile(symbolsPattern).matcher(password).find()) {
            return ValidationResult.PASSWORD_NO_SYMBOLS;
        }

        return ValidationResult.VALID;
    }

    public ValidationResult validateRoleId(int roleId) {
        if (roleId == RoleID.EMPLOYEE.getDBValue() || roleId == RoleID.ADMIN.getDBValue()) {
            return ValidationResult.VALID;
        }
        return ValidationResult.INVALID_ROLE_ID;
    }

    public ValidationResult validateRegisterDetails(RegisterDetails registerDetails) {
        ValidationResult result = validateEmail(registerDetails.getEmail());
        if (result != ValidationResult.VALID) {
            return result;
        }
        result = validateRoleId(registerDetails.getRoleId());
        if (result != ValidationResult.VALID) {
            return result;
        }
        return validatePassword(registerDetails.getPassword());
    }
}
