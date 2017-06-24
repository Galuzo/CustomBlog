package by.training.blog.implementations;

import by.training.blog.AbstractService;
import by.training.blog.dto.converters.interfaces.IPostConverter;
import by.training.blog.dto.posts.PostForCreateDto;
import by.training.blog.dto.posts.PostInfoDto;
import by.training.blog.entities.Post;
import by.training.blog.entities.User;
import by.training.blog.exceptions.ServiceException;
import by.training.blog.interfaces.IPostDao;
import by.training.blog.interfaces.IPostService;
import by.training.blog.interfaces.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.GregorianCalendar;
import java.util.Set;

/**
 * Created by Win on 19.06.2017.
 */
@Service
@Transactional
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
        post.setLikesCount(0);
        return dao.save(post);
    }

    @Override
    public void doRepost(int userId, int postId) throws ServiceException {
        User user = userDao.getById(userId);
        Post post = (Post)dao.getById(postId);
        if (user == null) {
            throw new ServiceException("User was not found");
        } else if (post==null) {
            throw new ServiceException("Post was not found");
        }
        user.getReposts().add(post);
        userDao.update(user);
    }

    @Override
    public void deleteRepost(int userId, int postId) throws ServiceException {
        User user = userDao.getById(userId);
        Post searchedPost = (Post)dao.getById(postId);
        if (user == null) {
            throw new ServiceException("User was not found");
        } else if (searchedPost==null) {
            throw new ServiceException("Post was not found");
        }
        Set<Post> reposts = user.getReposts();
        for (Post post : reposts) {
            if (post == searchedPost) {
                reposts.remove(post);
            }
        }
        userDao.update(user);
    }

    @Override
    public void deleteAllReposts(int userId) throws ServiceException {
        User user = userDao.getById(userId);
        if (user == null) {
            throw new ServiceException("User was not found");
        }
        user.getReposts().clear();
        userDao.update(user);
    }



}
