package by.training.blog.implementations;

import by.training.blog.AbstractService;
import by.training.blog.dto.comments.CommentInfoDto;
import by.training.blog.dto.converters.interfaces.ICommentConverter;
import by.training.blog.entities.Comment;
import by.training.blog.entities.Post;
import by.training.blog.entities.User;
import by.training.blog.exceptions.NotFoundException;
import by.training.blog.interfaces.ICommentDao;
import by.training.blog.interfaces.ICommentService;
import by.training.blog.interfaces.IPostDao;
import by.training.blog.interfaces.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Win on 20.06.2017.
 */
@Service
@Transactional
public class CommentService extends AbstractService<Comment, CommentInfoDto> implements ICommentService {

    @Autowired
    private ICommentDao commentDao;

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IPostDao postDao;

    @Autowired
    public CommentService(ICommentDao dao, ICommentConverter converter) {
        super(dao, converter);
    }

    @Override
    public int save(int userId, int postId,String text) {
        Comment comment = new Comment();
        User user = userDao.getById(userId);
        comment.setCommentAuthor(user);
        Post post = postDao.getById(postId);
        comment.setPost(post);
        comment.setText(text);
        return dao.save(comment);
    }

    @Override
    public List<CommentInfoDto> findByAuthor(int userId) throws NotFoundException{
        User user = userDao.getById(userId);
        if (user == null) {
            throw new NotFoundException("user was not found");
        }
        return converter.entityListToDtoList(commentDao.findByAuthor(user));
    }
}
