package by.training.blog.interfaces;

import by.training.blog.dto.subscriptions.SubscriptionForCreateDto;
import by.training.blog.dto.subscriptions.SubscriptionInfoDto;
import by.training.blog.dto.users.UserInfoDto;
import by.training.blog.exceptions.ExistUserException;
import by.training.blog.exceptions.NotFoundException;

import java.util.List;

/**
 * Created by Win on 28.06.2017.
 */
public interface ISubscriptionService extends IService<SubscriptionInfoDto> {

    int subscribe(int userId,SubscriptionForCreateDto entity) throws NotFoundException,ExistUserException;
    void unsubscribe(int userId, int otherUserId) throws NotFoundException;
    void unsubscribeFromAll(int userId) throws NotFoundException;
    List<UserInfoDto> showAllSubscriptions(int userId) throws NotFoundException;
}
