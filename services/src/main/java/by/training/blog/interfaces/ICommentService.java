package by.training.blog.interfaces;

/**
 * Created by Win on 20.06.2017.
 */
import by.training.blog.dto.comments.CommentInfoDto;

public interface ICommentService extends IService<CommentInfoDto>{
    int save(CommentInfoDto entity);

}
