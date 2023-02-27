package com.inditex.pot.slc.utils.exceptions;

import com.inditex.pot.slc.utils.exceptions.model.Message;
import com.inditex.pot.slc.utils.exceptions.model.Type;
import com.inditex.pot.slc.utils.exceptions.model.Error;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Optional;

/**
 * Functional Exception
 * Base Exception of all application exceptions
 *
 * @author slc
 * @since 1.0.0
 */
@Data
public class FunctionalException extends RuntimeException {
    private final Error error;
    private Optional<HttpStatus> httpStatus;

    public FunctionalException(String alias, String message, Type typeError) {
        super(message);
        this.error =
            Error.builder().addMessage(
                Message.builder()
                    .alias(alias)
                    .message(message)
                    .type(typeError)
                    .build())
                .build();
    }

    public FunctionalException(String alias, String message, Type typeError, HttpStatus httpStatus) {
        this(alias, message, typeError);
        this.httpStatus = Optional.of(httpStatus);
    }
}
