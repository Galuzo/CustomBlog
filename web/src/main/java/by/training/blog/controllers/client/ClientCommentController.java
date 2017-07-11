package by.training.blog.controllers.client;

import by.training.blog.controllers.exceptions.NoAccessException;
import by.training.blog.dto.comments.CommentForCreateDto;
import by.training.blog.dto.comments.CommentInfoDto;
import by.training.blog.entities.Comment;
import by.training.blog.exceptions.NotFoundException;
import by.training.blog.exceptions.ServiceException;
import by.training.blog.exceptions.WrongArgumentsException;
import by.training.blog.interfaces.ICommentService;
import by.training.blog.responses.SuccessResponse;
import by.training.blog.security.details.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Win on 28.06.2017.
 */
@RestController
@RequestMapping("/api/v1/client/comments")
public class ClientCommentController {

    @Autowired
    private ICommentService commentService;

    @RequestMapping(value = "/posts/{id}",method = RequestMethod.POST)
    public ResponseEntity<SuccessResponse> save(@PathVariable("id") int postId, @RequestBody CommentForCreateDto commentForCreateDto) throws NotFoundException, WrongArgumentsException {
        int userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        int commentId=  commentService.save(userId,postId, commentForCreateDto.getText());
        return new ResponseEntity<>(new SuccessResponse(commentId, HttpStatus.CREATED.toString()), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<SuccessResponse> deleteComment(@PathVariable int id) throws NoAccessException, NotFoundException {
        int userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        if (commentService.getById(id).getAuthorId() != userId) {
            throw new NoAccessException("not enough access");
        }
        commentService.delete(id);
        return new ResponseEntity<>(new SuccessResponse(id, HttpStatus.OK.toString()), HttpStatus.OK);
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ResponseEntity<List<CommentInfoDto>> showAllComments() throws NotFoundException {
        int userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        List<CommentInfoDto> comments=commentService.findByAuthor(userId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
}
