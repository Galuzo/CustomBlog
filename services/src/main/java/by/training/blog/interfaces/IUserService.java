package by.training.blog.interfaces;

import by.training.blog.dto.users.UserForCreateDto;
import by.training.blog.dto.users.UserInfoDto;
import by.training.blog.exceptions.ServiceException;

/**
 * Created by Win on 20.06.2017.
 */
public interface IUserService extends IService<UserInfoDto> {
    int save(UserForCreateDto entity);
    void addFriend(int userId, int otherUserId) throws ServiceException;
    void deleteFriend(int userId, int otherUserId) throws ServiceException;
    void deleteAllFriends(int userId) throws ServiceException;

}
