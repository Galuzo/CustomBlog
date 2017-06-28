package by.training.blog.interfaces;

import by.training.blog.entities.Comment;
import by.training.blog.entities.User;

import java.util.List;

/**
 * Created by Win on 17.06.2017.
 */
public interface ICommentDao extends IDao<Comment> {
    List<Comment> findByAuthor(User user);
}
