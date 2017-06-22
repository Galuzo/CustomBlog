package by.training.blog.implementations;

import by.training.blog.AbstractService;
import by.training.blog.dto.converters.interfaces.IPostConverter;
import by.training.blog.dto.posts.PostForCreateDto;
import by.training.blog.dto.posts.PostInfoDto;
import by.training.blog.entities.Post;
import by.training.blog.entities.User;
import by.training.blog.interfaces.IPostDao;
import by.training.blog.interfaces.IPostService;
import by.training.blog.interfaces.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.GregorianCalendar;

/**
 * Created by Win on 19.06.2017.
 */
@Service
public class PostService extends AbstractService<Post,PostInfoDto> implements IPostService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    public PostService(IPostDao dao, IPostConverter converter) {
        super(dao, converter);
    }

    @Override
    public int save(int userId, PostForCreateDto entity)
    {
        Post post = new Post();
        User user = userDao.getById(userId);
        post.setAuthor(user);
        post.setTitle(entity.getTitle());
        post.setBody(entity.getBody());
        post.setDate(GregorianCalendar.getInstance().getTime());
        post.setLikes(0);
        return dao.save(post);
    }
}
