package by.training.blog.dto.likes;

import by.training.blog.dto.BaseDto;

/**
 * Created by Win on 24.06.2017.
 */
public class LikeForCreateDto extends BaseDto {
    private int userId;
    private int postId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
