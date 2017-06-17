package by.training.blog.implementations;

import by.training.blog.entities.Comment;
import by.training.blog.interfaces.ICommentDao;
import org.springframework.stereotype.Repository;

/**
 * Created by Win on 17.06.2017.
 */
@Repository
public class CommentDao extends AbstractDao<Comment> implements ICommentDao {
    public CommentDao() {
        super(Comment.class);
    }
}
