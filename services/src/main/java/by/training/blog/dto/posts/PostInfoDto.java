package by.training.blog.dto.posts;

import by.training.blog.dto.BaseDto;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by Win on 19.06.2017.
 */
public class PostInfoDto  extends BaseDto{
    private String title;
    private String body;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;
    private int likesCount;
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

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
