package by.training.blog.dto.posts;

import by.training.blog.dto.BaseDto;

import java.util.Date;

/**
 * Created by Win on 19.06.2017.
 */
public class PostInfoDto  extends BaseDto{
    private String title;
    private String body;
    private Date date;
    private int likes;
    private int authorId;

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

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
