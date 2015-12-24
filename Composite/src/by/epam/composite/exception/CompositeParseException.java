package by.epam.composite.exception;

/**
 * Created by Maxim Selyuk on 16.12.15.
 */
public class CompositeParseException extends Exception {
    public CompositeParseException() {
    }

    public CompositeParseException(String message) {
        super(message);
    }

    public CompositeParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public CompositeParseException(Throwable cause) {
        super(cause);
    }

    public CompositeParseException(String message,
                                   Throwable cause,
                                   boolean enableSuppression,
                                   boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
