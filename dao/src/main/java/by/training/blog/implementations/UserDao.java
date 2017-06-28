package by.training.blog.implementations;

import by.training.blog.AbstractDao;
import by.training.blog.entities.Role;
import by.training.blog.entities.User;
import by.training.blog.enums.RoleType;
import by.training.blog.interfaces.IUserDao;
import org.springframework.stereotype.Repository;

/**
 * Created by Win on 17.06.2017.
 */
@Repository
public class UserDao extends AbstractDao<User> implements IUserDao {
    public UserDao() {
        super(User.class);
    }


    @Override
    @SuppressWarnings("unchecked")
    public User getByEmail(String email) {
        return (User) entityManager
                .createQuery("from User user where user.email = :email")
                .setParameter("email", email)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    }
}

