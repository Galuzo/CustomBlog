package by.training.blog.dto.messages;

import by.training.blog.dto.BaseDto;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by Win on 17.06.2017.
 */
public class MessageInfoDto extends BaseDto {
    private int toUser_id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    private int fromUser_id;
    private String Text;

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public int getToUser_id() {
        return toUser_id;
    }

    public void setToUser_id(int toUser_id) {
        this.toUser_id = toUser_id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getFromUser_id() {
        return fromUser_id;
    }

    public void setFromUser_id(int fromUser_id) {
        this.fromUser_id = fromUser_id;
    }
}
