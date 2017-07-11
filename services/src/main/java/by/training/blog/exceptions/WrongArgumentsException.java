package by.training.blog.exceptions;

/**
 * Created by Win on 09.07.2017.
 */
public class WrongArgumentsException extends ServiceException {
    public WrongArgumentsException(String message) {
        super(message);
    }

    public WrongArgumentsException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongArgumentsException() {
    }
}
