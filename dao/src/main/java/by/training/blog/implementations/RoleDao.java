package by.training.blog.implementations;

import by.training.blog.entities.Role;
import by.training.blog.interfaces.IRoleDao;
import by.training.blog.enums.RoleType;
import org.springframework.stereotype.Repository;

/**
 * Created by Win on 17.06.2017.
 */
@Repository
public class RoleDao extends AbstractDao<Role> implements IRoleDao {

    public RoleDao() {
        super(Role.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Role findByName(RoleType roleType) {
        return (Role) entityManager
                .createQuery("from Role role where role.title = :role")
                .setParameter("role", roleType)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    }
}
