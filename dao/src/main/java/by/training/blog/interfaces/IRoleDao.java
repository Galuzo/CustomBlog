package by.training.blog.interfaces;

import by.training.blog.entities.Role;
import by.training.blog.enums.RoleType;

/**
 * Created by Win on 17.06.2017.
 */
public interface IRoleDao extends IDao<Role> {
    Role findByName(RoleType roleType);
}
