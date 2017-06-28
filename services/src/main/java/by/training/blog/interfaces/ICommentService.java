package by.training.blog.interfaces;

/**
 * Created by Win on 20.06.2017.
 */
import by.training.blog.dto.comments.CommentInfoDto;
import by.training.blog.entities.Comment;
import by.training.blog.exceptions.NotFoundException;

import java.util.List;

public interface ICommentService extends IService<CommentInfoDto>{
    int save(int userId, int postId,String text);
    List<CommentInfoDto> findByAuthor(int userId) throws NotFoundException;


}
