package by.training.blog.interfaces;

import by.training.blog.dto.likes.LikeForCreateDto;
import by.training.blog.entities.Like;
import by.training.blog.exceptions.ServiceException;

import java.util.List;

/**
 * Created by Win on 24.06.2017.
 */
public interface ILikeService {
    void likePost(LikeForCreateDto likeForCreateDto) throws ServiceException;
    List<Like> showAllUserLikes(int userId) throws ServiceException;
}
