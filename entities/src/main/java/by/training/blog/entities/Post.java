package by.training.blog.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Win on 12.06.2017.
 */
@Entity
@Table(name="posts")
public class Post extends AbstractEntity {
    @Column(nullable = false,unique = true)
    private String title;

    @Column(nullable = false)
    private String body;

    @Column(name = "dateOfPost")
    private Date date;

    @Column(name = "likes")
    private int likes;

    @ManyToOne
    @JoinColumn(name="user_id")
    public User getAuthor() {
        return author;
    }
    public void setAuthor(User author) {
        this.author = author;
    }
    private User author;

    @OneToMany(mappedBy = "post")
    public Set<Comment> getComments() {
        return comments;
    }
    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
    private Set<Comment> comments;



    public Post() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (likes != post.likes) return false;
        if (!title.equals(post.title)) return false;
        if (!body.equals(post.body)) return false;
        return date != null ? date.equals(post.date) : post.date == null;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + body.hashCode();
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + likes;
        return result;
    }
}
