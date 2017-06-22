package by.training.blog.dto.posts;

import by.training.blog.dto.BaseDto;

/**
 * Created by Win on 19.06.2017.
 */
public class PostForCreateDto  extends BaseDto{
    private String title;
    private String body;
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

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
