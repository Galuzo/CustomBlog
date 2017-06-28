package by.training.blog.dto.converters.impls;

import by.training.blog.dto.comments.CommentInfoDto;
import by.training.blog.dto.converters.interfaces.ICommentConverter;
import by.training.blog.entities.Comment;
import by.training.blog.entities.Post;
import by.training.blog.interfaces.IPostDao;
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
    public Comment dtoToEntity(CommentInfoDto dto) {
        Comment comment = new Comment();
        comment.setText(dto.getText());
        comment.setId(dto.getId());
        Post post = postDao.getById(dto.getPostId());
        comment.setPost(post);
        return comment;
    }
}
