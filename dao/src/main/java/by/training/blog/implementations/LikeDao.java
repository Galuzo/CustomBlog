package by.training.blog.implementations;

import by.training.blog.AbstractDao;
import by.training.blog.entities.Like;
import by.training.blog.entities.Post;
import by.training.blog.entities.User;
import by.training.blog.interfaces.ILikeDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by Win on 24.06.2017.
 */
@Repository
public class LikeDao extends AbstractDao<Like> implements ILikeDao {

    public LikeDao() {
        super(Like.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Like findByUserAndPost(User user,Post post) {
        return  (Like) entityManager
                .createQuery("from Like lik where lik.user = :user and lik.likedPost=:post")
                .setParameter("user", user)
                .setParameter("post",post)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Like> findByUser(User user) {
        return  (List<Like>) entityManager
                .createQuery("from Like lik where lik.user = :user ")
                .setParameter("user", user)
                .getResultList();

    }
}
