package by.training.blog.implementations;

import by.training.blog.AbstractService;
import by.training.blog.dto.converters.interfaces.ISubscriptionConverter;
import by.training.blog.dto.subscriptions.SubscriptionForCreateDto;
import by.training.blog.dto.subscriptions.SubscriptionInfoDto;
import by.training.blog.dto.users.UserForUpdateDto;
import by.training.blog.dto.users.UserInfoDto;
import by.training.blog.entities.Subscription;
import by.training.blog.entities.User;
import by.training.blog.exceptions.ExistUserException;
import by.training.blog.exceptions.NotFoundException;
import by.training.blog.interfaces.ISubscriptionDao;
import by.training.blog.interfaces.ISubscriptionService;
import by.training.blog.interfaces.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Win on 28.06.2017.
 */
@Service
@Transactional
public class SubscriptionService extends AbstractService<Subscription,SubscriptionInfoDto> implements ISubscriptionService{

    @Autowired
    private IUserDao userDao;

    @Autowired
    private ISubscriptionDao subscriptionDao;

    @Autowired
    public SubscriptionService(ISubscriptionDao dao, ISubscriptionConverter converter) {
        super(dao, converter);
    }


    @Override
    public int subscribe(int userId, SubscriptionForCreateDto entity) throws NotFoundException,ExistUserException{
        Subscription subscription = new Subscription();
        User user = userDao.getById(userId);
        User friend = userDao.getById(entity.getFriendId());
        if(user==null)
        {
            throw new NotFoundException("user was not found");
        } else if (friend == null) {
            throw new NotFoundException("friend was not found");
        }
        if (subscriptionDao.findByUserAndFriend(user, friend) != null) {
            throw new ExistUserException("subscription is already exists");
        }
        subscription.setWhoSubscribes(user);
        subscription.setFriend(friend);
        return subscriptionDao.save(subscription);
    }

    @Override
    public void unsubscribe(int userId, int otherUserId)  throws NotFoundException{
        User user=  userDao.getById(userId);
        User friend =  userDao.getById(otherUserId);
        if (user == null) {
            throw new NotFoundException("user was not found");
        } else if (friend == null) {
            throw new NotFoundException("friend was not found");
        }
        List<Subscription> subscriptions = subscriptionDao.findByUser(user);
        for (Subscription subscription : subscriptions) {
            if (subscription.getFriend().getId() == friend.getId()) {
                subscriptionDao.delete(subscription.getId());
            }
        }
    }

    @Override
    public void unsubscribeFromAll(int userId) throws NotFoundException{
        User user=  userDao.getById(userId);
        if (user == null) {
            throw new NotFoundException("user was not found");
        }
        List<Subscription> subscriptions = subscriptionDao.findByUser(user);
        for (Subscription subscription : subscriptions) {
            subscriptionDao.delete(subscription.getId());
        }
    }

    @Override
    public List<UserInfoDto> showAllSubscriptions(int userId) throws NotFoundException{
        List<UserInfoDto> users = new ArrayList<>();
        User user=  userDao.getById(userId);
        if (user == null) {
            throw new NotFoundException("user was not found");
        }
        List<Subscription> subscriptions = subscriptionDao.findByUser(user);
        for (Subscription subscription : subscriptions) {
            UserInfoDto userInfoDto = new UserInfoDto();
            User friend = userDao.getById(subscription.getFriend().getId());
            userInfoDto.setRole(friend.getRole().toString());
            userInfoDto.setLastOnline(friend.getLastOnline());
            userInfoDto.setLastName(friend.getLastName());
            userInfoDto.setFirstName(friend.getFirstName());
            users.add(userInfoDto);
        }
        return users;
    }
}
