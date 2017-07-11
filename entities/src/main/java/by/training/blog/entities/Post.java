package by.training.blog.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Win on 12.06.2017.
 */
@Entity
@Table(name="posts")
public class Post extends AbstractEntity {

    @Column(nullable = false)
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    private String title;

    @Column(nullable = false)
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    private String body;

    @Column(name = "dateOfPost")
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    private Date date;

    @Column(name = "likeCount")
    public int getLikesCount() {
        return likesCount;
    }
    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }
    private int likesCount;


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
    private Set<Comment> comments=new HashSet<>();

    @ManyToMany(mappedBy ="reposts",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public Set<User> getUsers() {
        return users;
    }
    public void setUsers(Set<User> users) {
        this.users = users;
    }
    private Set<User> users = new HashSet<>();

    @OneToMany(mappedBy = "likedPost",cascade = CascadeType.ALL)
    public Set<Like> getLikes() {
        return likes;
    }
    public void setLikes(Set<Like> likes) {
        this.likes = likes;
    }
    private Set<Like> likes=new HashSet<>();



    public Post() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (likesCount != post.likesCount) return false;
        if (!title.equals(post.title)) return false;
        if (!body.equals(post.body)) return false;
        return date != null ? date.equals(post.date) : post.date == null;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + body.hashCode();
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + likesCount;
        return result;
    }
}
