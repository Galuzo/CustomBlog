package by.training.blog.controllers.exceptions;

/**
 * Created by Win on 28.06.2017.
 */
public class NoAccessException extends Exception {
    public NoAccessException(String message) {
        super(message);
    }

    public NoAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoAccessException() {
    }
}
