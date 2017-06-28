package by.training.blog;

import by.training.blog.dto.BaseDto;
import by.training.blog.dto.converters.interfaces.IConverter;
import by.training.blog.entities.AbstractEntity;
import by.training.blog.exceptions.NotFoundException;
import by.training.blog.exceptions.ServiceException;
import by.training.blog.interfaces.IDao;
import by.training.blog.interfaces.IService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public abstract class AbstractService<T1 extends AbstractEntity,T2 extends BaseDto> implements IService<T2> {

    protected IDao dao;
    protected IConverter converter;

    public AbstractService(IDao dao, IConverter converter) {
        this.dao = dao;
        this.converter = converter;
    }

    public List<T2> getAll() {
        List<T1> entityList=dao.getAll();
        List<T2> dtoInfoList = converter.entityListToDtoList(entityList);
        return dtoInfoList;
    }

    public T2 getById(int entityId) {
        T1 entity = (T1)dao.getById(entityId);
        T2 infoDto = (T2)converter.entityToDto(entity);
        return infoDto;
    }

    public void delete(int entityId) throws NotFoundException {
        if (dao.getById(entityId) != null) {
            dao.delete(entityId);
        }
        else
        {
            throw new NotFoundException("entity was not found");
        }
    }

    public void update(int entityId,T2 infoDto) {
        T1 entity = (T1)converter.dtoToEntity(infoDto);
        entity.setId(entityId);
        dao.update(entity);
    }
}
