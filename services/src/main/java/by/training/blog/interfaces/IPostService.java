package by.training.blog.interfaces;


import by.training.blog.dto.posts.PostForCreateDto;
import by.training.blog.dto.posts.PostInfoDto;


/**
 * Created by Win on 19.06.2017.
 */
public interface IPostService extends IService<PostInfoDto> {
    int save(int userId,PostForCreateDto entity);

}
