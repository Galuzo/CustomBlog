package by.training.blog.exceptions;

/**
 * Created by Win on 17.06.2017.
 */
public class MessageNotFound extends ServiceException {

    public MessageNotFound(String message) {
        super(message);
    }

    public MessageNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public MessageNotFound() {
    }
}
