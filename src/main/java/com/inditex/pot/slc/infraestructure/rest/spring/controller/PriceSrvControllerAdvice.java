package com.inditex.pot.slc.infraestructure.rest.spring.controller;

import com.inditex.pot.slc.infraestructure.rest.spring.dto.PriceResponseDTO;
import com.inditex.pot.slc.utils.exceptions.FunctionalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Controller advice responsible to manage all excerption produced
 * in controller
 */
@RestControllerAdvice
public class PriceSrvControllerAdvice {

    @ExceptionHandler(FunctionalException.class)
    protected ResponseEntity<PriceResponseDTO> exceptionControllerHandle(FunctionalException functionalException) {
        return
            ResponseEntity
                .status(
                    functionalException.getHttpStatus().orElseGet( () -> HttpStatus.INTERNAL_SERVER_ERROR))
            .body(
                PriceResponseDTO.builder().errors(functionalException.getError()).build());
    }
}
