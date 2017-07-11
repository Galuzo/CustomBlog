package by.training.blog.controllers.client;

import by.training.blog.dto.subscriptions.SubscriptionForCreateDto;
import by.training.blog.dto.users.UserInfoDto;
import by.training.blog.entities.Subscription;
import by.training.blog.entities.User;
import by.training.blog.exceptions.ExistUserException;
import by.training.blog.exceptions.NotFoundException;
import by.training.blog.interfaces.ISubscriptionService;
import by.training.blog.responses.SuccessResponse;
import by.training.blog.security.details.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * Created by Win on 28.06.2017.
 */
@RestController
@RequestMapping("/api/v1/client/subscriptions")
public class ClientSubscriptionController {

    @Autowired
    private ISubscriptionService followerService;

    @RequestMapping(value = "/users/{id}",method = RequestMethod.POST)
    public ResponseEntity<SuccessResponse> subscribe(@PathVariable("id") int followerId) throws NotFoundException, ExistUserException {
        int userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        SubscriptionForCreateDto subscriptionForCreateDto = new SubscriptionForCreateDto();
        subscriptionForCreateDto.setFriendId(followerId);
        followerService.subscribe(userId,subscriptionForCreateDto);
        return new ResponseEntity<>(new SuccessResponse(userId, HttpStatus.OK.toString()), HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<SuccessResponse> unsubscribe(@PathVariable("id") int followerId)throws NotFoundException {
        int userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        followerService.unsubscribe(userId,followerId);
        return new ResponseEntity<>(new SuccessResponse(userId, HttpStatus.OK.toString()), HttpStatus.OK);
    }

    @RequestMapping(value = "",method = RequestMethod.DELETE)
    public ResponseEntity<SuccessResponse> unsubscribeFromAll()throws NotFoundException {
        int userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        followerService.unsubscribeFromAll(userId);
        return new ResponseEntity<>(new SuccessResponse(userId, HttpStatus.OK.toString()), HttpStatus.OK);
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ResponseEntity<List<UserInfoDto>> showAllSubscriptions() throws NotFoundException {
        int userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        List<UserInfoDto> list=followerService.showAllSubscriptions(userId);
        return  new ResponseEntity<>(list,HttpStatus.OK);
    }


}
