package by.training.blog.dto.subscriptions;

import by.training.blog.dto.BaseDto;

/**
 * Created by Win on 28.06.2017.
 */
public class SubscriptionInfoDto extends BaseDto{
    private int userId;
    private int friendId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }
}
