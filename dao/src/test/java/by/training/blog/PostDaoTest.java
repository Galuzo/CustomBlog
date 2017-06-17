package by.training.blog;

import by.training.blog.entities.Post;
import by.training.blog.interfaces.IPostDao;
import javafx.geometry.Pos;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Win on 17.06.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:dao-context-test.xml")
@Transactional
public class PostDaoTest {

    private final String TITLE = "test";
    private final String BODY = "body";
    @Autowired
    private IPostDao postDao;

    @Test
    public void saveShouldSaveObject() {
        Post post = createObjectPost();
        int id=postDao.save(post);
        Post gettedObject = postDao.getById(id);
        assertNotNull(gettedObject);
    }

    @Test(expected = IllegalArgumentException.class)
    public void saveShouldReturnException() {
        Post post = null;
        postDao.save(post);
    }


    @Test
    public void getAllShouldReturnObjects() {
        Post firstPost = createObjectPost();
        Post secondPost = createObjectPost();
        postDao.save(firstPost);
        postDao.save(secondPost);
        assertEquals (2,postDao.getAll().size());
    }

    @Test
    public void getAllShouldReturnZero() {
        tearDown();
        assertEquals(0,postDao.getAll().size());
    }

    @Test
    public void getByIdShouldReturnObject() {
        Post post = createObjectPost();
        int id=postDao.save(post);
        assertNotNull(postDao.getById(id));
    }

    @Test()
    public void getByIdShouldReturnNull() {
        Post post = createObjectPost();
        postDao.save(post);
        assertEquals(null, postDao.getById(-1));
    }



    private Post createObjectPost() {
        Post post = new Post();
        post.setBody(BODY);
        post.setTitle(TITLE);
        return post;
    }


    @Test
    public void deleteShouldDeleteObject() {
        Post post = createObjectPost();
        int id = postDao.save(post);
        postDao.delete(id);
        assertNull(postDao.getById(id));
    }

    @Test
    public void update() {
        String updatedTitle = "Updated";
        Post post = createObjectPost();
        int id=postDao.save(post);
        post.setTitle(updatedTitle);
        postDao.update(post);
        post = null;
        post = postDao.getById(id);
        Post expectedPost = new Post();
        expectedPost.setTitle(updatedTitle);
        expectedPost.setBody(BODY);
        expectedPost.setId(id);
        assertEquals(expectedPost,post);
    }

    @Test
    public void updateShouldReturnNotEquals() {
        String updatedTitle = "Updated";
        Post post = createObjectPost();
        int id=postDao.save(post);
        post.setTitle(updatedTitle);
        postDao.update(post);
        post = null;
        post = postDao.getById(id);
        Post expectedPost = new Post();
        expectedPost.setTitle("false");
        expectedPost.setBody(BODY);
        expectedPost.setId(id);
        assertNotEquals(expectedPost,post);
    }

    @After
    public void tearDown() {
        List<Post> list = postDao.getAll();
        for (Post post : list) {
            postDao.delete(post.getId());
        }
    }


}
