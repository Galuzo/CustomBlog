package by.training.blog.interfaces;

import by.training.blog.dto.users.UserForCreateDto;
import by.training.blog.dto.users.UserInfoDto;

/**
 * Created by Win on 20.06.2017.
 */
public interface IUserService extends IService<UserInfoDto> {
    int save(UserForCreateDto entity);

}
