package by.training.blog.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Win on 17.06.2017.
 */
@Entity
@Table(name="users")
public class User extends AbstractEntity {
    @Column(name="firstName",nullable = false)
    private String firstName;
    @Column(name="lastName",nullable = false)
    private String lastName;
    @Column(name="password",nullable = false)
    private String password;
    @Column(name="email",nullable = false,unique = true)
    private String email;
    @Column(name = "lastOnline")
    private Date lastOnline;
    @Column(name="dateOfSignUp")
    private Date dateOfSignUp;

    @ManyToOne
    @JoinColumn(name="role_id")
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    private Role role;

    @OneToMany(mappedBy = "author")
    public Set<Post> getPosts() {
        return posts;
    }
    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
    private Set<Post> posts=new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "followers",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "follower_id", referencedColumnName = "id")
    )
    public Set<User> getFollowers() {
        return followers;
    }
    public void setFollowers(Set<User> followers) {
        this.followers = followers;
    }
    private Set<User> followers = new HashSet<>();



    @OneToMany(mappedBy = "fromUser")
    public Set<Message> getMessagesFrom() {
        return messagesFrom;
    }
    public void setMessagesFrom(Set<Message> messagesFrom) {
        this.messagesFrom = messagesFrom;
    }
    private Set<Message> messagesFrom=new HashSet<>();

    @OneToMany(mappedBy = "toUser")
    public Set<Message> getMessagesTo() {
        return messagesTo;
    }
    public void setMessagesTo(Set<Message> messagesTo) {
        this.messagesTo = messagesTo;
    }
    private Set<Message> messagesTo=new HashSet<>();



    @ManyToMany()
    @JoinTable(name = "reposts", joinColumns = {
            @JoinColumn(name = "post_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "user_id",
                    nullable = false, updatable = false)})
    public Set<Post> getReposts() {
        return reposts;
    }
    public void setReposts(Set<Post> reposts) {
        this.reposts = reposts;
    }
    private Set<Post> reposts=new HashSet<>();

    @OneToMany(mappedBy = "user")
    public Set<Like> getLikes() {
        return likes;
    }
    public void setLikes(Set<Like> likes) {
        this.likes = likes;
    }
    private Set<Like> likes=new HashSet<>();



    public User() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastOnline() {
        return lastOnline;
    }

    public void setLastOnline(Date lastOnline) {
        this.lastOnline = lastOnline;
    }

    public Date getDateOfSignUp() {
        return dateOfSignUp;
    }

    public void setDateOfSignUp(Date dateOfSignUp) {
        this.dateOfSignUp = dateOfSignUp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!firstName.equals(user.firstName)) return false;
        if (!lastName.equals(user.lastName)) return false;
        if (!password.equals(user.password)) return false;
        if (!email.equals(user.email)) return false;
        if (lastOnline != null ? !lastOnline.equals(user.lastOnline) : user.lastOnline != null) return false;
        return dateOfSignUp != null ? dateOfSignUp.equals(user.dateOfSignUp) : user.dateOfSignUp == null;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + (lastOnline != null ? lastOnline.hashCode() : 0);
        result = 31 * result + (dateOfSignUp != null ? dateOfSignUp.hashCode() : 0);
        return result;
    }
}
