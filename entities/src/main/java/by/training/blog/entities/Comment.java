package by.training.blog.entities;

import javax.persistence.*;

/**
 * Created by Win on 17.06.2017.
 */
@Entity
@Table(name ="comments")
public class Comment extends AbstractEntity {
    @Column(name="text")
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    private String text;

    @ManyToOne()
    @JoinColumn(name="post_id")
    public Post getPost() {
        return post;
    }
    public void setPost(Post post) {
        this.post = post;
    }
    private Post post;


    @ManyToOne()
    @JoinColumn(name="author_id")
    public User getCommentAuthor() {
        return commentAuthor;
    }
    public void setCommentAuthor(User commentAuthor) {
        this.commentAuthor = commentAuthor;
    }
    private User commentAuthor;

    public Comment() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (!text.equals(comment.text)) return false;
        return post.equals(comment.post);
    }

    @Override
    public int hashCode() {
        int result = text.hashCode();
        result = 31 * result + post.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "text='" + text + '\'' +
                ", post=" + post +
                '}';
    }
}

