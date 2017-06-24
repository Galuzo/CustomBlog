package by.training.blog.dto.converters.impls;

import by.training.blog.dto.converters.interfaces.IPostConverter;
import by.training.blog.dto.posts.PostInfoDto;
import by.training.blog.entities.Post;
import by.training.blog.entities.User;
import by.training.blog.interfaces.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Win on 19.06.2017.
 */
@Component
public class PostConverter implements IPostConverter {

    @Autowired
    private IUserDao userDao;
    @Override
    public PostInfoDto entityToDto(Post entity) {
        PostInfoDto postInfoDto = new PostInfoDto();
        postInfoDto.setTitle(entity.getTitle());
        postInfoDto.setAuthorId(entity.getAuthor().getId());
        postInfoDto.setDate(entity.getDate());
        postInfoDto.setBody(entity.getBody());
        postInfoDto.setLikesCount(entity.getLikesCount());
        postInfoDto.setId(entity.getId());
        return postInfoDto;    }

    @Override
    public List<PostInfoDto> entityListToDtoList(List<Post> entityList) {
        List<PostInfoDto> returnedList = new ArrayList<>();
        for (Post post : entityList) {
            PostInfoDto postInfoDto = entityToDto(post);
            returnedList.add(postInfoDto);
        }
        return returnedList;
    }

    @Override
    public Post dtoToEntity(PostInfoDto dto) {
        Post post = new Post();
        post.setBody(dto.getBody());
        post.setLikesCount(dto.getLikesCount());
        post.setTitle(dto.getTitle());
        post.setDate(dto.getDate());
        post.setId(dto.getId());
        User author = userDao.getById(dto.getAuthorId());
        post.setAuthor(author);
        return post;
    }
}
