package ru.thirteenth.kryptohouse.exception;

public class CurrencyTypeNotSupportedException extends RuntimeException{

    public CurrencyTypeNotSupportedException() {
    }

    public CurrencyTypeNotSupportedException(String message) {
        super(message);
    }

    public CurrencyTypeNotSupportedException(String message, Throwable cause) {
        super(message, cause);
    }
}
