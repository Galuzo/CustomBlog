package by.training.blog;

import by.training.blog.entities.AbstractEntity;
import by.training.blog.interfaces.IDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Win on 17.06.2017.
 */
public abstract class AbstractDao<T extends AbstractEntity> implements IDao<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    private Class persistentClass;


    public AbstractDao(Class persistentClass) {
        this.persistentClass = persistentClass;
    }

    @Override
    public List<T> getAll() {
        String hql = "FROM "+persistentClass.getName();
        return (List<T>) entityManager.createQuery(hql).getResultList();    }

    @Override
    public T getById(int entityId) {
        return (T)entityManager.find(persistentClass, entityId);
    }

    @Override
    public int save(T entity) {
        entityManager.persist(entity);
        return entity.getId();
    }

    @Override
    public void update(T entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(int entityId) {
        entityManager.remove(getById(entityId));
    }
}
