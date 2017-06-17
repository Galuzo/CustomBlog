package by.training.blog.interfaces;

import by.training.blog.entities.AbstractEntity;

import java.util.List;

/**
 * Created by Win on 17.06.2017.
 */
public interface IDao<T extends AbstractEntity> {
    List<T> getAll();
    T getById(int entityId);
    int save(T entity);
    void update(T entity);
    void delete(int entityId);
}
