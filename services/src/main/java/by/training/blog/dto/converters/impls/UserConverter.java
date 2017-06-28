package by.training.blog.dto.converters.impls;

import by.training.blog.dto.converters.interfaces.IUserConverter;
import by.training.blog.dto.users.UserForUpdateDto;
import by.training.blog.entities.Role;
import by.training.blog.entities.User;
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
    public User dtoToEntity(UserForUpdateDto dto) {
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
}
