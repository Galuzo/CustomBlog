package by.training.blog.interfaces;

import by.training.blog.dto.users.UserForCreateDto;
import by.training.blog.dto.users.UserForLoginDto;
import by.training.blog.dto.users.UserForUpdateDto;
import by.training.blog.exceptions.ExistUserException;
import by.training.blog.exceptions.IncorrectPasswordException;
import by.training.blog.exceptions.NotFoundException;

/**
 * Created by Win on 20.06.2017.
 */
public interface IUserService extends IService<UserForUpdateDto> {
    int save(UserForCreateDto entity) throws ExistUserException;

    int login(UserForLoginDto userForLoginDto) throws NotFoundException,IncorrectPasswordException;

}
