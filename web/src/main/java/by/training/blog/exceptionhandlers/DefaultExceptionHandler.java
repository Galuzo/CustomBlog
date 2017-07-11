package by.training.blog.exceptionhandlers;

import by.training.blog.exceptions.ExistUserException;
import by.training.blog.exceptions.IncorrectPasswordException;
import by.training.blog.exceptions.NotFoundException;
import by.training.blog.exceptions.WrongArgumentsException;
import by.training.blog.responses.FailedResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Win on 28.06.2017.
 */
@ControllerAdvice
public class DefaultExceptionHandler {
    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<FailedResponse> notFoundHandler(Exception e) throws Exception {
        FailedResponse failedResponse = new FailedResponse(e.getMessage(), HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<>(failedResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ExistUserException.class)
    public ResponseEntity<FailedResponse> userExistHandler(Exception e) throws Exception {
        FailedResponse failedResponse = new FailedResponse(e.getMessage(), HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(failedResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = WrongArgumentsException.class)
    public ResponseEntity<FailedResponse> wrongArguments(Exception e) throws Exception {
        FailedResponse failedResponse = new FailedResponse(e.getMessage(), HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(failedResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = IncorrectPasswordException.class)
    public ResponseEntity<FailedResponse> incorrectPassword(Exception e) throws Exception {
        FailedResponse failedResponse = new FailedResponse(e.getMessage(), HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(failedResponse, HttpStatus.BAD_REQUEST);
    }
}
