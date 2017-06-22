package by.training.blog.dto.converters.impls;

import by.training.blog.dto.converters.interfaces.IMessageConverter;
import by.training.blog.dto.messages.MessageInfoDto;
import by.training.blog.entities.Message;
import by.training.blog.entities.User;
import by.training.blog.interfaces.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Win on 17.06.2017.
 */
@Component
public class MessageConverter implements IMessageConverter {

    @Autowired
    private IUserDao userDao;

    @Override
    public MessageInfoDto entityToDto(Message entity) {
        MessageInfoDto messageInfoDto = new MessageInfoDto();
        messageInfoDto.setId(entity.getId());
        messageInfoDto.setToUser_id(entity.getToUser().getId());
        messageInfoDto.setCreateDate(entity.getCreateDate());
        messageInfoDto.setFromUser_id(entity.getFromUser().getId());
        messageInfoDto.setText(entity.getText());
        return messageInfoDto;
    }

    @Override
    public List<MessageInfoDto> entityListToDtoList(List<Message> entityList) {
        List<MessageInfoDto> returnedList = new ArrayList<>();
        for (Message message : entityList) {
            MessageInfoDto messageInfoDto = entityToDto(message);
            returnedList.add(messageInfoDto);
        }
        return returnedList;
    }

    @Override
    public Message dtoToEntity(MessageInfoDto dto) {
        Message message = new Message();
        message.setId(dto.getId());
        User toUser = userDao.getById(dto.getToUser_id());
        User fromUser = userDao.getById(dto.getFromUser_id());
        message.setToUser(toUser);
        message.setFromUser(fromUser);
        message.setText(dto.getText());
        message.setCreateDate(dto.getCreateDate());
        return message;
    }


}
