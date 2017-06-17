package by.training.blog.implementations;

import by.training.blog.entities.Role;
import by.training.blog.interfaces.IRoleDao;
import org.springframework.stereotype.Repository;

/**
 * Created by Win on 17.06.2017.
 */
@Repository
public class RoleDao extends AbstractDao<Role> implements IRoleDao {
    public RoleDao() {
        super(Role.class);
    }
}
