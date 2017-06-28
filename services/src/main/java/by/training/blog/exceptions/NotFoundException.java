package by.training.blog.exceptions;

/**
 * Created by Win on 28.06.2017.
 */
public class NotFoundException extends ServiceException {
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException() {
    }
}
