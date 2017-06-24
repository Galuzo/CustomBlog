package by.training.blog.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by Win on 24.06.2017.
 */
@Entity
@Table(name="likes")
public class Like extends AbstractEntity {

    @ManyToOne()
    @JoinColumn(name="post_id")
    public Post getLikedPost() {
        return likedPost;
    }
    public void setLikedPost(Post likedPost) {
        this.likedPost = likedPost;
    }
    private Post likedPost;

    @ManyToOne
    @JoinColumn(name="user_id")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    private User user;

    public Like() {
    }
}
