package by.training.blog.implementations;

import by.training.blog.AbstractDao;
import by.training.blog.entities.Message;
import by.training.blog.interfaces.IMessageDao;
import org.springframework.stereotype.Repository;

/**
 * Created by Win on 17.06.2017.
 */
@Repository
public class MessageDao extends AbstractDao<Message> implements IMessageDao {
    public MessageDao() {
        super(Message.class);
    }
}
