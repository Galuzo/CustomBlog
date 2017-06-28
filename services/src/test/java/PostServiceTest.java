import by.training.blog.dto.posts.PostForCreateDto;
import by.training.blog.dto.posts.PostInfoDto;
import by.training.blog.entities.Post;
import by.training.blog.entities.User;
import by.training.blog.exceptions.ServiceException;
import by.training.blog.interfaces.IPostDao;
import by.training.blog.interfaces.IPostService;
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

import static org.junit.Assert.*;

/**
 * Created by Win on 24.06.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:service-context-test.xml")
@Transactional
public class PostServiceTest {
    @Autowired
    private IPostDao postDao;

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IPostService postService;
    private User user;
    private Post post;
    private final String TEST = "TEST";

    @Before
    public void setUp() {
        user = createUser();
        post = saveTestingPost();

    }

    @Test
    public void saveShouldSaveObject() {
        PostForCreateDto postForCreateDto = createPostForCreate();
        int id=postService.save(user.getId(), postForCreateDto);
        Post expectedPost = postDao.getById(id);
        assertNotNull(expectedPost);
    }

    @Test
    public void updateShouldChangeObject() {
        PostInfoDto postInfoDto = createPostInfoDto();
        postInfoDto.setTitle("updated");
        postService.update(postInfoDto.getId(),postInfoDto);
        Post gettedPost = postDao.getById(postInfoDto.getId());
        assertEquals("updated",gettedPost.getTitle());
    }

    @Test
    public void deleteShouldDeleteObject() throws ServiceException {
        postService.delete(post.getId());
        assertEquals(null, postDao.getById(post.getId()));
    }

    @Test(expected = ServiceException.class)
    public void deleteShouldThrowsException() throws ServiceException {
        postService.delete(-1);
    }

    @Test
    public void getById() {
        PostInfoDto gettedPost=postService.getById(post.getId());
        assertNotNull(gettedPost);
    }

    @Test
    public void getAll() {
        assertNotNull(postService.getAll());
    }

    @Test
    public void doRepost() throws ServiceException {
        postService.doRepost(user.getId(),post.getId());
        assert (user.getReposts().size()>0);
    }

    @Test(expected = ServiceException.class)
    public  void doRepostShouldThrowsException() throws ServiceException {
        postService.doRepost(-2,post.getId());
    }

    @Test
    public void deleteRepostShouldBesuccessful() throws ServiceException {
        postService.doRepost(user.getId(),post.getId());
        postService.deleteRepost(user.getId(),post.getId());
        assertFalse(user.getReposts().contains(post));
    }

    @Test
    public void deleteAllReposts() throws ServiceException {
        postService.doRepost(user.getId(),post.getId());
        postService.deleteAllReposts(user.getId());
        assertTrue(user.getReposts().isEmpty());
    }





    private User createUser() {
      User  user = new User();
        user.setPassword(TEST);
        user.setLastOnline(GregorianCalendar.getInstance().getTime());
        user.setLastName(TEST);
        user.setEmail(TEST);
        int userId=userDao.save(user);
        user = userDao.getById(userId);
        return user;
    }

    private PostForCreateDto createPostForCreate() {
        PostForCreateDto postForCreateDto = new PostForCreateDto();
        postForCreateDto.setBody(TEST);
        postForCreateDto.setTitle(TEST);
        return postForCreateDto;
    }

    private PostInfoDto createPostInfoDto() {
        PostInfoDto postInfoDto = new PostInfoDto();
        postInfoDto.setAuthorId(user.getId());
        postInfoDto.setBody(TEST);
        postInfoDto.setDate(GregorianCalendar.getInstance().getTime());
        postInfoDto.setTitle(TEST);
        postInfoDto.setLikesCount(0);
        postInfoDto.setId(post.getId());
        return postInfoDto;
    }

    private Post saveTestingPost() {
        Post post = new Post();
        post.setLikesCount(0);
        post.setTitle(TEST);
        post.setDate(GregorianCalendar.getInstance().getTime());
        post.setBody(TEST);
        post.setAuthor(userDao.getById(user.getId()));
        int id=postDao.save(post);
        post = postDao.getById(id);
        return post;
    }
}
