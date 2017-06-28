package by.training.blog.dto.comments;

import by.training.blog.dto.BaseDto;

/**
 * Created by Win on 28.06.2017.
 */
public class CommentForCreateDto extends BaseDto {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
