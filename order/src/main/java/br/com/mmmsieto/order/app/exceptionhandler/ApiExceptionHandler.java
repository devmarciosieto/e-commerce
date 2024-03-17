package br.com.mmmsieto.order.app.exceptionhandler;

import br.com.mmmsieto.order.domain.exceptions.DomainException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ApiExceptionHandler {

    // TODO arrumar para o patrão rfc7807  https://datatracker.ietf.org/doc/html/rfc7807
    private static final Logger log = LoggerFactory.getLogger(ApiExceptionHandler.class);
    @ExceptionHandler(DomainException.class)
    public ResponseEntity<?> getDomainException(DomainException domainException) {

        log.error("Domain exception occurred: {}", domainException.getErrors());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(domainException);
    }



}
