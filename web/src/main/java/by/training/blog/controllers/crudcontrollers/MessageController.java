package by.training.blog.controllers.crudcontrollers;

import by.training.blog.dto.messages.MessageForCreateDto;
import by.training.blog.dto.messages.MessageInfoDto;
import by.training.blog.interfaces.IMessageService;
import by.training.blog.interfaces.IService;
import by.training.blog.responses.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Win on 26.06.2017.
 */
@RestController
@RequestMapping("api/messages")
public class MessageController extends AbstractController<MessageInfoDto> {

    @Autowired
    private IMessageService messageService;
    @Override
    protected IService getService() {
        return messageService;
    }

    @RequestMapping(value ="/{id}",method = RequestMethod.POST)
    public ResponseEntity<SuccessResponse> save(@PathVariable("id") int fromUserId,@RequestBody  MessageForCreateDto messageForCreateDto) {
        int id = messageService.save(fromUserId, messageForCreateDto);
        return new ResponseEntity<>(new SuccessResponse(id, HttpStatus.CREATED.toString()), HttpStatus.CREATED);
    }
}
