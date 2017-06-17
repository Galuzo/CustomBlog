package by.training.blog.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Win on 17.06.2017.
 */
@Entity
@Table(name = "messages")
public class Message extends AbstractEntity {
    @Column
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    private String text;

    @Column
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    private Date createDate;

    @ManyToOne
    @JoinColumn(name="userfrom_id")
    public User getFromUser() {
        return fromUser;
    }
    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }
    private User fromUser;

    @ManyToOne
    @JoinColumn(name = "userto_id")
    public User getToUser() {
        return toUser;
    }
    public void setToUser(User toUser) {
        this.toUser = toUser;
    }
    private User toUser;

    public Message() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (!text.equals(message.text)) return false;
        if (!fromUser.equals(message.fromUser)) return false;
        return toUser.equals(message.toUser);
    }

    @Override
    public int hashCode() {
        int result = text.hashCode();
        result = 31 * result + fromUser.hashCode();
        result = 31 * result + toUser.hashCode();
        return result;
    }
}
