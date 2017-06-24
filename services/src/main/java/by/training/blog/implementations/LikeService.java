package by.training.blog.implementations;

import by.training.blog.dto.likes.LikeForCreateDto;
import by.training.blog.entities.Like;
import by.training.blog.entities.Post;
import by.training.blog.entities.User;
import by.training.blog.exceptions.ServiceException;
import by.training.blog.interfaces.ILikeDao;
import by.training.blog.interfaces.ILikeService;
import by.training.blog.interfaces.IPostDao;
import by.training.blog.interfaces.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by Win on 24.06.2017.
 */
@Transactional
@Service
public class LikeService implements ILikeService{

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IPostDao postDao;

    @Autowired
    private ILikeDao likeDao;

    @Override
    public void likePost(LikeForCreateDto likeForCreateDto) throws ServiceException{
        Like like = new Like();
        User user = userDao.getById(likeForCreateDto.getUserId());
        Post post = postDao.getById(likeForCreateDto.getPostId());
        if (user == null) {
            throw new ServiceException("user was not found");
        } else if (post == null) {
            throw new ServiceException("post was not found");
        }
        if (likeDao.findByUserAndPost(user,post) == null) {
            post.setLikesCount(post.getLikesCount()+1);
            like.setUser(user);
            like.setLikedPost(post);
            likeDao.save(like);
            postDao.update(post);
        }
        else {
            post.setLikesCount(post.getLikesCount()-1);
            like=likeDao.findByUserAndPost(user,post);
            likeDao.delete(like.getId());
            postDao.update(post);
        }
    }

    @Override
    public List<Like> showAllUserLikes(int userId) throws ServiceException {
        User user=userDao.getById(userId);
        if (user == null) {
            throw new ServiceException("user was not found");
        }
        return likeDao.findByUser(user);
    }


}
