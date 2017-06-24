package by.training.blog.interfaces;

import by.training.blog.entities.Like;
import by.training.blog.entities.Post;
import by.training.blog.entities.User;

import java.util.List;
import java.util.Set;

/**
 * Created by Win on 24.06.2017.
 */
public interface ILikeDao extends IDao<Like> {
    Like findByUserAndPost(User user, Post post);
    List<Like> findByUser(User user);
}
