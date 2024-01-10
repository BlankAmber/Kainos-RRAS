package org.kainos.ea.client;

import org.kainos.ea.core.RegisterValidator;

public class InvalidRegisterException extends Exception {
    public static String validationResultToErrorMessage(
            RegisterValidator.ValidationResult validationResult) {
        switch (validationResult) {
            case EMAIL_INCORRECT_FORMAT:
                return "Email is in an incorrect format";
            case PASSWORD_TOO_SHORT:
                return "Password must be at least eight characters";
            case PASSWORD_NO_UPPERCASE_CHARACTERS:
                return "Password must contain at least one uppercase character";
            case PASSWORD_NO_LOWERCASE_CHARACTERS:
                return "Password must contain at least one lowercase character";
            case PASSWORD_NO_SYMBOLS:
                return "Password must contain at least one symbol";
            default:
                return null;
        }
    }

    public InvalidRegisterException(RegisterValidator.ValidationResult validationResult) {
        super(validationResultToErrorMessage(validationResult));
    }
}
