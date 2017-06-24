package by.training.blog.implementations;

import by.training.blog.AbstractService;
import by.training.blog.dto.converters.interfaces.IUserConverter;
import by.training.blog.dto.users.UserForCreateDto;
import by.training.blog.dto.users.UserInfoDto;
import by.training.blog.entities.User;
import by.training.blog.enums.RoleType;
import by.training.blog.exceptions.ServiceException;
import by.training.blog.interfaces.IRoleDao;
import by.training.blog.interfaces.IUserDao;
import by.training.blog.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.GregorianCalendar;

/**
 * Created by Win on 20.06.2017.
 */
@Service
@Transactional
public class UserService extends AbstractService<User,UserInfoDto> implements IUserService {
    @Autowired
    private IRoleDao roleDao;
    @Autowired
    public UserService(IUserDao dao, IUserConverter converter) {
        super(dao, converter);
    }

    @Override
    public int save(UserForCreateDto entity) {
        User user = new User();
        user.setFirstName(entity.getFirstName());
        user.setEmail(entity.getEmail());
        user.setDateOfSignUp(GregorianCalendar.getInstance().getTime());
        user.setLastName(entity.getLastName());
        user.setLastOnline(GregorianCalendar.getInstance().getTime());
        user.setPassword(entity.getPassword());
        user.setRole(roleDao.findByName(RoleType.USER));
        return dao.save(user);
    }

    @Override
    public void addFriend(int userId, int otherUserId) throws ServiceException{
        User user= (User) dao.getById(userId);
        User friend = (User) dao.getById(otherUserId);
        if (user == null) {
            throw new ServiceException("user was not found");
        } else if (friend == null) {
            throw new ServiceException("friend was not found");
        }
        user.getFollowers().add(friend);
        dao.update(user);
    }

    @Override
    public void deleteFriend(int userId, int otherUserId)  throws ServiceException{
        User user= (User) dao.getById(userId);
        User friend = (User) dao.getById(otherUserId);
        if (user == null) {
            throw new ServiceException("user was not found");
        } else if (friend == null) {
            throw new ServiceException("friend was not found");
        }
        if (!user.getFollowers().contains(friend)) {
            throw new ServiceException("friend was not found in the followers list");
        }
        user.getFollowers().remove(friend);
        dao.update(user);
    }

    @Override
    public void deleteAllFriends(int userId) throws ServiceException{
        User user= (User) dao.getById(userId);
        if (user == null) {
            throw new ServiceException("user was not found");
        }
        user.getFollowers().clear();
        dao.update(user);
    }
}
