package by.training.blog.interfaces;


import by.training.blog.dto.messages.MessageForCreateDto;
import by.training.blog.dto.messages.MessageInfoDto;
import by.training.blog.exceptions.NotFoundException;
import by.training.blog.exceptions.WrongArgumentsException;

/**
 * Created by Win on 17.06.2017.
 */
public interface IMessageService  extends IService<MessageInfoDto>{
    int save(int userId,MessageForCreateDto entity) throws NotFoundException, WrongArgumentsException;

}
