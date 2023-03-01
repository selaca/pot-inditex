package com.inditex.pot.slc.infraestructure.rest.spring.controller;

import com.inditex.pot.slc.infraestructure.rest.spring.dto.PriceResponseDTO;
import com.inditex.pot.slc.utils.commons.exceptions.FunctionalException;
import com.inditex.pot.slc.utils.commons.exceptions.model.Error;
import com.inditex.pot.slc.utils.commons.exceptions.model.Message;
import com.inditex.pot.slc.utils.commons.exceptions.model.Type;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Stream;

/**
 * Controller advice responsible to manage all exception produced
 * by service
 */
@RestControllerAdvice
public class PriceSrvControllerAdvice {

    @ExceptionHandler(FunctionalException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseEntity<PriceResponseDTO> functionalExceptionControllerHandle(FunctionalException functionalException) {
        return
            ResponseEntity
                .status(
                    functionalException.getHttpStatus().orElseGet( () -> HttpStatus.INTERNAL_SERVER_ERROR))
                .body(
                    PriceResponseDTO.builder().errors(functionalException.getError()).build());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseEntity<PriceResponseDTO> runtimeExceptionControllerHandle(RuntimeException runtimeException) {
        Error errors =
            Error.builder().addMessage(
                Message.builder()
                    .alias("Infraestructure Exception")
                    .message(runtimeException.getMessage())
                    .type(Type.ERROR).build())
                .build();

        return
            ResponseEntity
                .status(
                    HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                    PriceResponseDTO.builder().errors(errors).build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<PriceResponseDTO> methodArgumentNotValidhandle(MethodArgumentNotValidException methodArgumentException) {
        List<FieldError> fieldErrors = methodArgumentException.getBindingResult().getFieldErrors();
        List<ObjectError> globalErrors = methodArgumentException.getBindingResult().getGlobalErrors();

        Message[] messages =
            Stream.concat(fieldErrors.stream(), globalErrors.stream())
                .map( fieldError -> Message.builder()
                    .alias("Infraestructure Exception")
                    .message(fieldError.getDefaultMessage())
                    .type(Type.FATAL))
                .toArray(Message[]::new);

        return
            ResponseEntity
                .status(
                    HttpStatus.BAD_REQUEST)
                .body(
                    PriceResponseDTO.builder()
                        .errors(
                            Error.builder().addMessages(messages).build())
                        .build());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<PriceResponseDTO> handleConstraintViolatedException(ConstraintViolationException ex) {

        Message[] messages =
            ex.getConstraintViolations().stream()
                .map(constraintViolation -> Message.builder()
                    .alias("Infraestructure Exception")
                    .message(constraintViolation.getMessage())
                    .type(Type.FATAL))
                .toArray(Message[]::new);

        return
            ResponseEntity
                .status(
                        HttpStatus.BAD_REQUEST)
                .body(
                    PriceResponseDTO.builder()
                        .errors(
                                Error.builder().addMessages(messages).build())
                        .build());
    }
}
