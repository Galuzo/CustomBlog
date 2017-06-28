package by.training.blog.interfaces;

import by.training.blog.entities.Role;
import by.training.blog.entities.Subscription;
import by.training.blog.entities.User;

import java.util.List;

/**
 * Created by Win on 28.06.2017.
 */
public interface ISubscriptionDao extends IDao<Subscription> {
    List<Subscription> findByUser(User user);
    Subscription findByUserAndFriend(User user,User friend);
}
