package com.inditex.pot.slc.utils.commons.exceptions.model;

import lombok.Builder;
import lombok.Data;

/**
 * Message of error
 *
 * @author slc
 * @since 1.0.0
 */
@Data
@Builder
public class Message {
    /**  alias of exception error */
    private String alias;
    /** message of error */
    private String message;
    /** Error type */
    private Type type;
}
