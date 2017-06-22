package by.training.blog.implementations;

import by.training.blog.AbstractService;
import by.training.blog.dto.converters.interfaces.IMessageConverter;
import by.training.blog.dto.messages.MessageForCreateDto;
import by.training.blog.dto.messages.MessageInfoDto;
import by.training.blog.entities.Message;
import by.training.blog.interfaces.IMessageDao;
import by.training.blog.interfaces.IMessageService;
import by.training.blog.interfaces.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.GregorianCalendar;

/**
 * Created by Win on 17.06.2017.
 */
@Service
public class MessageService  extends AbstractService<Message,MessageInfoDto> implements IMessageService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    public MessageService(IMessageDao dao, IMessageConverter converter) {
        super(dao, converter);
    }

    @Override
    public int save(int userId,MessageForCreateDto messageForCreate) {
        Message message = new Message();
        message.setCreateDate(GregorianCalendar.getInstance().getTime());
        message.setText(messageForCreate.getText());
        message.setFromUser(userDao.getById(userId));
        message.setToUser(userDao.getById(messageForCreate.getToUser_id()));
        return dao.save(message);
    }


}
