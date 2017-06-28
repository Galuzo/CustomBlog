package by.training.blog.implementations;

import by.training.blog.AbstractDao;
import by.training.blog.entities.Subscription;
import by.training.blog.entities.User;
import by.training.blog.interfaces.ISubscriptionDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Win on 28.06.2017.
 */
@Repository
public class SubscriptionDao extends AbstractDao<Subscription> implements ISubscriptionDao {

    public SubscriptionDao() {
        super(Subscription.class);
    }

    @SuppressWarnings("unchecked")
    public List<Subscription> findByUser(User user) {
        return  (List<Subscription>) entityManager
                .createQuery("from Subscription subscr where subscr.whoSubscribes = :user ")
                .setParameter("user", user)
                .getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Subscription findByUserAndFriend(User user, User friend) {
        return (Subscription) entityManager
                .createQuery("from Subscription subscr where subscr.whoSubscribes = :user and subscr.friend=:friend ")
                .setParameter("user", user)
                .setParameter("friend",friend)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    }
}
