package by.training.blog.controllers;

//import by.training.blog.entities.Role;
import by.training.blog.dto.roles.RoleInfoDto;
//import by.training.blog.interfaces.IRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Win on 16.06.2017.
 */
@RestController
public class TestController {

    @Autowired
    private IRoleService roleService;

    @Transactional
    @RequestMapping("/")
    public int add() {
        RoleInfoDto roleInfoDto = new RoleInfoDto();
        roleInfoDto.setTitle("SDADS");
        return roleService.save(roleInfoDto);
    }


}
