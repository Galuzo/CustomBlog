package by.training.blog.implementations;

import by.training.blog.AbstractService;
import by.training.blog.dto.converters.interfaces.IUserConverter;
import by.training.blog.dto.users.UserForCreateDto;
import by.training.blog.dto.users.UserInfoDto;
import by.training.blog.entities.User;
import by.training.blog.enums.RoleType;
import by.training.blog.interfaces.IRoleDao;
import by.training.blog.interfaces.IUserDao;
import by.training.blog.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.GregorianCalendar;

/**
 * Created by Win on 20.06.2017.
 */
@Service
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
}
