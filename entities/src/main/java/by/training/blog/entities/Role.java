package by.training.blog.entities;

import by.training.blog.utils.RoleType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by Win on 17.06.2017.
 */
@Entity
@Table(name="roles")
public class Role  extends AbstractEntity{
    @Column(name="title")
    public RoleType getTitle() {
        return title;
    }
    public void setTitle(RoleType title) {
        this.title = title;
    }
    private RoleType title;

    @OneToMany(mappedBy = "role")
    public Set<User> getUsers() {
        return users;
    }
    public void setUsers(Set<User> users) {
        this.users = users;
    }
    private Set<User> users;

    public Role() {
    }
}
