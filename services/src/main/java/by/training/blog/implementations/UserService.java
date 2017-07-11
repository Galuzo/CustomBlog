package by.training.blog.implementations;

import by.training.blog.AbstractService;
import by.training.blog.dto.converters.interfaces.IUserConverter;
import by.training.blog.dto.users.UserForCreateDto;
import by.training.blog.dto.users.UserForLoginDto;
import by.training.blog.dto.users.UserForUpdateDto;
import by.training.blog.entities.User;
import by.training.blog.enums.RoleType;
import by.training.blog.exceptions.ExistUserException;
import by.training.blog.exceptions.IncorrectPasswordException;
import by.training.blog.exceptions.NotFoundException;
import by.training.blog.exceptions.WrongArgumentsException;
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
public class UserService extends AbstractService<User,UserForUpdateDto> implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Autowired
    private IRoleDao roleDao;

    @Autowired
    public UserService(IUserDao dao, IUserConverter converter) {
        super(dao, converter);
    }

    @Override
    public int save(UserForCreateDto entity) throws ExistUserException, WrongArgumentsException {
        if (entity.getPassword().trim().length() == 0) {
            throw new WrongArgumentsException("the password is empty");
        } else if (entity.getEmail().trim().length() == 0) {
            throw new WrongArgumentsException("the email is empty");
        } else if (entity.getFirstName().trim().length() == 0) {
            throw new WrongArgumentsException("the first Name is empty");
        } else if (entity.getLastName().trim().length() == 0) {
            throw new WrongArgumentsException("the last Name is empty");
        }
        if(userDao.getByEmail(entity.getEmail())!=null)
        {
            throw new ExistUserException("user is already exists");
        }
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
    public int login(UserForLoginDto userForLoginDto)  throws NotFoundException,IncorrectPasswordException{
        User user = userDao.getByEmail(userForLoginDto.getEmail());
        if (user == null) {
            throw new NotFoundException("User not found!");
        } else if (!user.getPassword().equals(userForLoginDto.getPassword())) {
            throw new IncorrectPasswordException("Incorrect password entered!");
        } else {
            return user.getId();
        }
    }
}
