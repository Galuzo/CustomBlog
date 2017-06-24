package by.training.blog.implementations;

import by.training.blog.AbstractDao;
import by.training.blog.entities.User;
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
}
