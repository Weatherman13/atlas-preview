package ru.thirteenth.kryptohouse.exception;

public class PairDoesNotExistException extends RuntimeException{
    public PairDoesNotExistException() {
    }

    public PairDoesNotExistException(String message) {
        super(message);
    }

    public PairDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }


}
