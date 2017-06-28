package by.training.blog.controllers.crudcontrollers;

import by.training.blog.dto.users.UserForCreateDto;
import by.training.blog.dto.users.UserForUpdateDto;
import by.training.blog.exceptions.ExistUserException;
import by.training.blog.interfaces.IService;
import by.training.blog.interfaces.IUserService;
import by.training.blog.responses.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Win on 26.06.2017.
 */
@RestController
@RequestMapping("api/users")
public class UserController  extends AbstractController<UserForUpdateDto> {
    @Autowired
    private IUserService userService;

    @Override
    protected IService getService() {
        return userService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SuccessResponse> save(@RequestBody UserForCreateDto userForCreateDto) throws ExistUserException {
        int id=userService.save(userForCreateDto);
        return new ResponseEntity<>(new SuccessResponse(id, HttpStatus.CREATED.toString()), HttpStatus.CREATED);
    }
}
