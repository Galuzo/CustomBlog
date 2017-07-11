package by.training.blog.controllers.crudcontrollers;

import by.training.blog.dto.BaseDto;
import by.training.blog.exceptions.NotFoundException;
import by.training.blog.exceptions.ServiceException;
import by.training.blog.exceptions.WrongArgumentsException;
import by.training.blog.interfaces.IService;
import by.training.blog.responses.SuccessResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Win on 26.06.2017.
 */
public abstract class AbstractController<T extends BaseDto> {
    protected abstract IService getService();

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    protected ResponseEntity<SuccessResponse> update(@PathVariable("id") int entityId,@RequestBody T dto) throws NotFoundException, WrongArgumentsException {
        if (getService().getById(entityId) == null) {
            throw new NotFoundException("object is absent");
        }
        getService().update(entityId,dto);
        return new ResponseEntity<>(new SuccessResponse(entityId, HttpStatus.OK.toString()), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    protected ResponseEntity<List<T>> getAll() {
        List<T> list = getService().getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value ="/{id}",method = RequestMethod.GET)
    protected ResponseEntity<T> getById(@PathVariable int id) throws NotFoundException {
        T object = (T)getService().getById(id);
        if (object != null) {
            return new ResponseEntity<>(object, HttpStatus.OK);
        } else {
            throw new NotFoundException("object is absent");
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    protected ResponseEntity<SuccessResponse> deleteById(@PathVariable int id) throws ServiceException {
        if (getService().getById(id) == null) {
            throw new NotFoundException("object is absent");
        }
        getService().delete(id);
        return new ResponseEntity<>(new SuccessResponse(id, HttpStatus.OK.toString()), HttpStatus.OK);
    }


}
