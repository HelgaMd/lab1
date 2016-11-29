package com.etu.etitkov;

/**
 * Negative value exception
 *
 * @author etitkov
 */
public class NegativeValueException extends Exception {

    public NegativeValueException() {
        super();
    }

    public NegativeValueException(String message) {
        super(message);
    }

    public NegativeValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeValueException(Throwable cause) {
        super(cause);
    }

    protected NegativeValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
