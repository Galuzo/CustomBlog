package by.training.blog.implementations;

import by.training.blog.AbstractDao;
import by.training.blog.entities.Comment;
import by.training.blog.entities.User;
import by.training.blog.interfaces.ICommentDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Win on 17.06.2017.
 */
@Repository
public class CommentDao extends AbstractDao<Comment> implements ICommentDao {
    public CommentDao() {
        super(Comment.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Comment> findByAuthor(User user) {
        return (List<Comment>) entityManager
                .createQuery("from Comment comment where comment.commentAuthor = :user ")
                .setParameter("user", user)
                .getResultList();
    }
}

