package ru.thirteenth.atlas.exception;

public class UserLanguageInvalidTypeException extends RuntimeException {
    public UserLanguageInvalidTypeException() {
    }

    public UserLanguageInvalidTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserLanguageInvalidTypeException(String message) {
        super(message);
    }

    public UserLanguageInvalidTypeException(Throwable cause) {
        super(cause);
    }
}

