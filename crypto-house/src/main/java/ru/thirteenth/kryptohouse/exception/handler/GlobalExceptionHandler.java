package ru.thirteenth.kryptohouse.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.thirteenth.kryptohouse.dto.ExceptionDetails;
import ru.thirteenth.kryptohouse.exception.FearAndGreedRequestIsEmptyException;

import javax.servlet.http.HttpServletRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.springframework.http.HttpStatus.SERVICE_UNAVAILABLE;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FearAndGreedRequestIsEmptyException.class)
    public ResponseEntity<ExceptionDetails> handleMalformedURLException(
            HttpServletRequest request,
            Exception exception)
    {
        return ResponseEntity.status(SERVICE_UNAVAILABLE).body(new ExceptionDetails(
                LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
                "At the moment, information about the index is not available",
                SERVICE_UNAVAILABLE.value()
        ));
    }
}
