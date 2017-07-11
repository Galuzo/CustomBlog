package by.training.blog.dto.converters.interfaces;

import by.training.blog.dto.BaseDto;
import by.training.blog.entities.AbstractEntity;
import by.training.blog.exceptions.NotFoundException;
import by.training.blog.exceptions.WrongArgumentsException;

import java.util.List;

/**
 * Created by Win on 19.06.2017.
 */
public interface IConverter<T1 extends BaseDto,T2 extends AbstractEntity> {
    T1 entityToDto(T2 entity);
    List<T1> entityListToDtoList(List<T2> entityList);
    T2 dtoToEntity(T1 dto) throws WrongArgumentsException, NotFoundException;
    void dtoHasErrors(T1 dto) throws WrongArgumentsException, NotFoundException;
}



