package ru.thirteenth.kryptohouse.exception;

public class FearAndGreedRequestIsEmptyException extends RuntimeException{
    public FearAndGreedRequestIsEmptyException() {
    }

    public FearAndGreedRequestIsEmptyException(String message) {
        super(message);
    }

    public FearAndGreedRequestIsEmptyException(Throwable cause) {
        super(cause);
    }
}
