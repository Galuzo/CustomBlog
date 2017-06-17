package by.training.blog.controllers;

import by.training.blog.entities.Post;
import by.training.blog.interfaces.IPostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Win on 16.06.2017.
 */
@RestController
public class TestController {

    @Autowired
    private IPostDao postDao;

    @Transactional
    @RequestMapping("/")
    public List<Post> add() {
        return postDao.getAll();
    }


}
