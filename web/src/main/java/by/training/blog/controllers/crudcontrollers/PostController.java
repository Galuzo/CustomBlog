package by.training.blog.controllers.crudcontrollers;

import by.training.blog.dto.posts.PostForCreateDto;
import by.training.blog.dto.posts.PostInfoDto;
import by.training.blog.exceptions.NotFoundException;
import by.training.blog.exceptions.WrongArgumentsException;
import by.training.blog.interfaces.IPostService;
import by.training.blog.interfaces.IService;
import by.training.blog.responses.FailedResponse;
import by.training.blog.responses.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Win on 26.06.2017.
 */
@RestController
@RequestMapping("/api/v1/admin/posts")
public class PostController extends AbstractController<PostInfoDto> {
    @Autowired
    private IPostService postService;

    @Override
    protected IService getService() {
        return postService;
    }

    @RequestMapping(value = "/users/{id}",method = RequestMethod.POST)
    public ResponseEntity<SuccessResponse> save(@PathVariable("id") int id,@RequestBody PostForCreateDto postForCreateDto) throws NotFoundException, WrongArgumentsException {
        int postId=postService.save(id, postForCreateDto);
        return new ResponseEntity<>(new SuccessResponse(postId, HttpStatus.CREATED.toString()), HttpStatus.CREATED);
    }


}
