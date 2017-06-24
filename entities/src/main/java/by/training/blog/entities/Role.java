package by.training.blog.entities;

import by.training.blog.enums.RoleType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Win on 17.06.2017.
 */
@Entity
@Table(name="roles")
public class Role  extends AbstractEntity{
    @Enumerated(EnumType.STRING)
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
    private Set<User> users=new HashSet<>();

    public Role() {
    }
}
