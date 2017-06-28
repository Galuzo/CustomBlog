package by.training.blog.controllers.crudcontrollers;

import by.training.blog.dto.comments.CommentInfoDto;
import by.training.blog.interfaces.ICommentService;
import by.training.blog.interfaces.IService;
import by.training.blog.responses.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Win on 26.06.2017.
 */
@RestController
@RequestMapping("/api/v1/comments")
public class CommentController extends AbstractController<CommentInfoDto> {

    @Autowired
    private ICommentService commentService;

    @Override
    protected IService getService() {
        return commentService;
    }

    @RequestMapping(value = "users/{id}",method = RequestMethod.POST)
    public ResponseEntity<SuccessResponse> save(@PathVariable int userId, @RequestBody CommentInfoDto commentInfoDto) {
        int id = commentService.save(userId,commentInfoDto.getPostId(),commentInfoDto.getText());
        return new ResponseEntity<>(new SuccessResponse(id, HttpStatus.CREATED.toString()), HttpStatus.CREATED);
    }
}
