package by.training.blog.dto.converters.impls;

import by.training.blog.dto.comments.CommentInfoDto;
import by.training.blog.dto.converters.interfaces.ICommentConverter;
import by.training.blog.entities.Comment;
import by.training.blog.entities.Post;
import by.training.blog.entities.User;
import by.training.blog.exceptions.NotFoundException;
import by.training.blog.exceptions.WrongArgumentsException;
import by.training.blog.interfaces.IPostDao;
import by.training.blog.interfaces.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Win on 20.06.2017.
 */
@Component
public class CommentConverter implements ICommentConverter {

    @Autowired
    private IPostDao postDao;

    @Autowired
    private IUserDao userDao;

    @Override
    public CommentInfoDto entityToDto(Comment entity) {
        CommentInfoDto commentInfoDto = new CommentInfoDto();
        commentInfoDto.setId(entity.getId());
        commentInfoDto.setText(entity.getText());
        commentInfoDto.setPostId(entity.getPost().getId());
        commentInfoDto.setAuthorId(entity.getCommentAuthor().getId());
        return commentInfoDto;
    }

    @Override
    public List<CommentInfoDto> entityListToDtoList(List<Comment> entityList) {
        List<CommentInfoDto> returnedList = new ArrayList<>();
        for (Comment comment : entityList) {
            CommentInfoDto commentInfoDto = entityToDto(comment);
            returnedList.add(commentInfoDto);
        }
        return returnedList;
    }

    @Override
    public Comment dtoToEntity(CommentInfoDto dto) throws WrongArgumentsException, NotFoundException {
        dtoHasErrors(dto);
        Comment comment = new Comment();
        comment.setText(dto.getText());
        comment.setId(dto.getId());
        User author = userDao.getById(dto.getAuthorId());
        comment.setCommentAuthor(author);
        Post post = postDao.getById(dto.getPostId());
        comment.setPost(post);
        return comment;
    }

    @Override
    public void dtoHasErrors(CommentInfoDto dto) throws WrongArgumentsException,NotFoundException {
        if (dto.getText().trim().length() == 0) {
            throw new WrongArgumentsException("The text is wrong");
        } else if (dto.getPostId() < 0) {
            throw new WrongArgumentsException("postId is negative");
        } else if (postDao.getById(dto.getPostId())==null) {
            throw new NotFoundException("post was not found");
        } else if (dto.getAuthorId() < 0) {
            throw new WrongArgumentsException("authorId is negative");
        } else if (userDao.getById(dto.getAuthorId()) == null) {
            throw new NotFoundException("author was not found");
        }
    }
}
