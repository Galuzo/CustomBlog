package by.training.blog.interfaces;


import by.training.blog.dto.posts.PostForCreateDto;
import by.training.blog.dto.posts.PostInfoDto;
import by.training.blog.exceptions.ServiceException;


/**
 * Created by Win on 19.06.2017.
 */
public interface IPostService extends IService<PostInfoDto> {
    int save(int userId,PostForCreateDto entity);
    void doRepost(int userId,int postId) throws ServiceException;
    void deleteRepost(int userId, int postId) throws ServiceException;
    void deleteAllReposts(int userId) throws ServiceException;

}
