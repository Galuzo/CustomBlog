package by.training.blog.exceptions;

/**
 * Created by Win on 28.06.2017.
 */
public class ExistUserException extends ServiceException {
    public ExistUserException(String message) {
        super(message);
    }

    public ExistUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExistUserException() {
    }
}
