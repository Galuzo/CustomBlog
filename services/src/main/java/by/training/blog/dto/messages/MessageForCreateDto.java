package by.training.blog.dto.messages;

import by.training.blog.dto.BaseDto;

/**
 * Created by Win on 17.06.2017.
 */
public class MessageForCreateDto extends BaseDto{
    private int toUser_id;
    private String text;

    public int getToUser_id() {
        return toUser_id;
    }
    public void setToUser_id(int toUser_id) {
        this.toUser_id = toUser_id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}
