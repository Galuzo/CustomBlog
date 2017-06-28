package by.training.blog.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by Win on 28.06.2017.
 */
@Entity
@Table(name="subscriptions")
public class Subscription  extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name="user_id")
    public User getWhoSubscribes() {
        return whoSubscribes;
    }
    public void setWhoSubscribes(User whoSubscribes) {
        this.whoSubscribes = whoSubscribes;
    }
    private User whoSubscribes;

    @ManyToOne
    @JoinColumn(name = "friend_id")
    public User getFriend() {
        return friend;
    }
    public void setFriend(User friend) {
        this.friend = friend;
    }
    private User friend;


}
