package com.inditex.pot.slc.utils.exceptions.model;

import lombok.Data;

import java.util.Arrays;

/**
 * Builder of application errors @see {@link java.lang.Error}
 *
 * @author slc
 * @since 1.0.0
 */
@Data
public class ErrorBuilder {
    private Message[] messages = new Message[0];

    /**
     * Add new Message to array message of error
     * @param message
     * @return
     */
    public ErrorBuilder addMessage(Message message) {
        setMessages(
            (Message[])append2Array(
                getMessages(),
                message));

        return this;
    }

    /**
     * Creates new instance of @Error
     * with messages selected
     *
     * @return
     */
    public Error build() {
        return
            new Error(
                getMessages() );
    }

    /* Helper methods --------------------------------------- */

    private static <T> T[] append2Array(T[] elements, T element) {
        T[] newArray = Arrays.copyOf(elements, elements.length + 1);
        newArray[elements.length] = element;
        return newArray;
    }
}
