package by.training.blog.exceptions;

/**
 * Created by Win on 28.06.2017.
 */
public class IncorrectPasswordException extends ServiceException {
    public IncorrectPasswordException(String message) {
        super(message);
    }

    public IncorrectPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectPasswordException() {
    }
}
