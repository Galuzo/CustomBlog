package by.training.blog.implementations;

import by.training.blog.AbstractService;
import by.training.blog.dto.comments.CommentInfoDto;
import by.training.blog.dto.converters.interfaces.ICommentConverter;
import by.training.blog.entities.Comment;
import by.training.blog.interfaces.ICommentDao;
import by.training.blog.interfaces.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Win on 20.06.2017.
 */
@Service
@Transactional
public class CommentService extends AbstractService<Comment,CommentInfoDto> implements ICommentService {
    @Autowired
    private ICommentConverter commentConverter;
    @Autowired
    public CommentService(ICommentDao dao, ICommentConverter converter) {
        super(dao, converter);
    }

    @Override
    public int save(CommentInfoDto entity) {
        Comment comment = commentConverter.dtoToEntity(entity);
       return dao.save(comment);
    }
}
