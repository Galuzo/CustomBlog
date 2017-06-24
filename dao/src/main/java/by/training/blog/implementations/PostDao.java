package by.training.blog.implementations;

import by.training.blog.AbstractDao;
import by.training.blog.entities.Post;
import by.training.blog.interfaces.IPostDao;
import org.springframework.stereotype.Repository;

/**
 * Created by Win on 16.06.2017.
 */
@Repository
public class PostDao  extends AbstractDao<Post> implements IPostDao {

    public PostDao() {
        super(Post.class);
    }
}
