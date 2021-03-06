package by.epam.taxistation.exception;

public class IllegalSetValueException extends Exception {
    public IllegalSetValueException() {
    }

    public IllegalSetValueException(String message) {
        super(message);
    }

    public IllegalSetValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalSetValueException(Throwable cause) {
        super(cause);
    }

    public IllegalSetValueException(String message,
                                    Throwable cause,
                                    boolean enableSuppression,
                                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
