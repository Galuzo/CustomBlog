package by.training.blog.dto.converters.impls;

import by.training.blog.dto.converters.interfaces.IUserConverter;
import by.training.blog.dto.users.UserForUpdateDto;
import by.training.blog.entities.Role;
import by.training.blog.entities.User;
import by.training.blog.exceptions.NotFoundException;
import by.training.blog.exceptions.WrongArgumentsException;
import by.training.blog.interfaces.IRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Win on 20.06.2017.
 */
@Component
public class UserConverter implements IUserConverter {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public UserForUpdateDto entityToDto(User entity) {
        UserForUpdateDto userInfoDto = new UserForUpdateDto();
        userInfoDto.setId(entity.getId());
        userInfoDto.setDateOfSignUp(entity.getDateOfSignUp());
        userInfoDto.setEmail(entity.getEmail());
        userInfoDto.setFirstName(entity.getFirstName());
        userInfoDto.setLastName(entity.getLastName());
        userInfoDto.setPassword(entity.getPassword());
        userInfoDto.setLastOnline(entity.getLastOnline());
        userInfoDto.setRoleId(entity.getRole().getId());
        return userInfoDto;
    }

    @Override
    public List<UserForUpdateDto> entityListToDtoList(List<User> entityList) {
        List<UserForUpdateDto> returnedList = new ArrayList<>();
        for (User user : entityList) {
            UserForUpdateDto userInfoDto = entityToDto(user);
            returnedList.add(userInfoDto);
        }
        return returnedList;
    }

    @Override
    public User dtoToEntity(UserForUpdateDto dto) throws NotFoundException, WrongArgumentsException {
        dtoHasErrors(dto);
        User user = new User();
        user.setLastOnline(dto.getLastOnline());
        user.setId(dto.getId());
        user.setPassword(dto.getPassword());
        user.setLastName(dto.getLastName());
        user.setDateOfSignUp(dto.getDateOfSignUp());
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        Role role = roleDao.getById(dto.getRoleId());
        user.setRole(role);
        return user;
    }

    @Override
    public void dtoHasErrors(UserForUpdateDto dto) throws WrongArgumentsException, NotFoundException {
        if (dto.getPassword().trim().length() == 0) {
            throw new WrongArgumentsException("the password is empty");
        } else if (dto.getEmail().trim().length() == 0) {
            throw new WrongArgumentsException("the email is empty");
        } else if (dto.getFirstName().trim().length() == 0) {
            throw new WrongArgumentsException("the first Name is empty");
        } else if (dto.getLastName().trim().length() == 0) {
            throw new WrongArgumentsException("the last Name is empty");
        } else if (roleDao.getById(dto.getRoleId()) == null) {
            throw new NotFoundException("the role was not found by this id");
        } else if (dto.getDateOfSignUp()==null) {
            throw new WrongArgumentsException("the date of sign up is empty");
        } else if (dto.getLastOnline()==null) {
        throw new WrongArgumentsException("the last online date  is empty");
    }

    }


}
