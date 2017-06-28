import by.training.blog.dto.likes.LikeForCreateDto;
import by.training.blog.entities.Like;
import by.training.blog.entities.Post;
import by.training.blog.entities.User;
import by.training.blog.exceptions.ServiceException;
import by.training.blog.interfaces.ILikeDao;
import by.training.blog.interfaces.ILikeService;
import by.training.blog.interfaces.IPostDao;
import by.training.blog.interfaces.IUserDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Win on 24.06.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:service-context-test.xml")
@Transactional
public class LikeServiceTest {
    @Autowired
    private ILikeService likeService;

    @Autowired
    private ILikeDao likeDao;
    @Autowired
    private IUserDao userDao;
    @Autowired
    private IPostDao postDao;

    private User user;
    private Post post;
    private final String TEST = "TEST";

    @Before
    public void setUp() {
        user = createUser();
        post = createPost();
    }

    @Test
    public void likePostShouldBeSuccessful() throws ServiceException {
        likeService.likePost(createLikeForCreateDto());
        assert(likeDao.findByUser(user).size()>0);
    }

    @Test
    public void likePostShouldDeleteLike() throws ServiceException {
        likeService.likePost(createLikeForCreateDto());
        likeService.likePost(createLikeForCreateDto());
        assertNull(likeDao.findByUserAndPost(user, post));
    }

    @Test(expected = ServiceException.class)
    public void LikePostShouldThrowsException() throws ServiceException {
        LikeForCreateDto likeForCreateDto = new LikeForCreateDto();
        likeForCreateDto.setPostId(-1);
        likeForCreateDto.setUserId(-1);
        likeService.likePost(likeForCreateDto);
    }



    @Test
    public void showAllUserLikes() throws ServiceException {
        likeService.likePost(createLikeForCreateDto());
        assert (likeService.showAllUserLikes(user.getId()).size()>0);
    }

    private LikeForCreateDto createLikeForCreateDto(){
        LikeForCreateDto likeForCreateDto = new LikeForCreateDto();
        likeForCreateDto.setUserId(user.getId());
        likeForCreateDto.setPostId(post.getId());
        return likeForCreateDto;
    }

    private User createUser() {
        User user = new User();
        user.setLastOnline(GregorianCalendar.getInstance().getTime());
        user.setLastName(TEST);
        user.setEmail(TEST);
        int userId=userDao.save(user);
        user = userDao.getById(userId);
        int id = userDao.save(user);
        return userDao.getById(id);
    }

    private Post createPost() {
        Post post = new Post();
        post.setBody(TEST);
        post.setTitle(TEST);
        post.setLikesCount(0);
        post.setDate(GregorianCalendar.getInstance().getTime());
        int id=postDao.save(post);
        return postDao.getById(id);
    }


}
