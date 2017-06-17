package by.training.blog.implementations;

import by.training.blog.entities.Post;
import by.training.blog.interfaces.IPostDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Win on 16.06.2017.
 */
@Repository
public class PostDao  extends AbstractDao<Post> implements IPostDao {

    public PostDao() {
        super(Post.class);
    }
}
