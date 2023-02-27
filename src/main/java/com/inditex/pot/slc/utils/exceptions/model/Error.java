package com.inditex.pot.slc.utils.exceptions.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Java bean represinting application errors
 *
 * @author slc
 * @since 1.0.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Error {
    /** Error messages */
    Message[] messages;

    public static ErrorBuilder builder() {
        return
            new ErrorBuilder();
    }
}
