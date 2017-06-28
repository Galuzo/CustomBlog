package by.training.blog.controllers.client;

import by.training.blog.dto.users.UserForCreateDto;
import by.training.blog.dto.users.UserForLoginDto;
import by.training.blog.exceptions.ExistUserException;
import by.training.blog.exceptions.IncorrectPasswordException;
import by.training.blog.exceptions.NotFoundException;
import by.training.blog.interfaces.IUserService;
import by.training.blog.responses.SuccessResponse;
import by.training.blog.security.services.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Win on 28.06.2017.
 */
@RestController
@RequestMapping("/api/v1")
public class GuestController {

    @Autowired
    private IUserService userService;
    @Autowired
    private ILoginService loginService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResponseEntity<SuccessResponse> register(@RequestBody UserForCreateDto userForCreateDto) throws ExistUserException {
       int id= userService.save(userForCreateDto);
        return new ResponseEntity<>(new SuccessResponse(id, HttpStatus.CREATED.toString()), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/login",method =RequestMethod.POST)
    public ResponseEntity<SuccessResponse> login(@RequestBody UserForLoginDto userForLoginDto) throws NotFoundException, IncorrectPasswordException {
        int id = userService.login(userForLoginDto);
        loginService.authenticate(userForLoginDto.getEmail(),userForLoginDto.getPassword());
        return new ResponseEntity<>(new SuccessResponse(id, HttpStatus.OK.toString()), HttpStatus.OK);
    }


}
