package by.training.blog.interfaces;

import by.training.blog.exceptions.NotFoundException;
import by.training.blog.exceptions.ServiceException;
import by.training.blog.exceptions.WrongArgumentsException;

import java.util.List;

/**
 * Created by Win on 17.06.2017.
 */
public interface IService<T> {
    List<T> getAll();
    T getById(int entityId) throws NotFoundException;
    void update(int entityId,T entity) throws WrongArgumentsException, NotFoundException;
    void delete(int entityId) throws NotFoundException;
}
