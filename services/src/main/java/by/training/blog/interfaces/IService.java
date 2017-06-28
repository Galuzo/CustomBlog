package by.training.blog.interfaces;

import by.training.blog.exceptions.NotFoundException;
import by.training.blog.exceptions.ServiceException;

import java.util.List;

/**
 * Created by Win on 17.06.2017.
 */
public interface IService<T> {
    List<T> getAll();
    T getById(int entityId);
    void update(int entityId,T entity);
    void delete(int entityId) throws NotFoundException;
}
