package ru.thirteenth.kryptohouse.parser;

public class JsonInvalidCbrParseException extends RuntimeException{
    public JsonInvalidCbrParseException() {
    }

    public JsonInvalidCbrParseException(String message) {
        super(message);
    }

    public JsonInvalidCbrParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
