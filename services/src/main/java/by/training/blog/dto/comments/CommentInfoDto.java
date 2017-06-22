package by.training.blog.dto.comments;

import by.training.blog.dto.BaseDto;

/**
 * Created by Win on 20.06.2017.
 */
public class CommentInfoDto extends BaseDto {
    private String text;
    private int postId;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
