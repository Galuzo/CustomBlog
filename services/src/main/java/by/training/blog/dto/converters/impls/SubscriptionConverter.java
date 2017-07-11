package by.training.blog.dto.converters.impls;

import by.training.blog.dto.converters.interfaces.ISubscriptionConverter;
import by.training.blog.dto.subscriptions.SubscriptionInfoDto;
import by.training.blog.entities.Subscription;
import by.training.blog.exceptions.WrongArgumentsException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Win on 28.06.2017.
 */
@Component
public class SubscriptionConverter implements ISubscriptionConverter {
    @Override
    public SubscriptionInfoDto entityToDto(Subscription entity) {
        SubscriptionInfoDto subscriptionInfoDto = new SubscriptionInfoDto();
        subscriptionInfoDto.setUserId(entity.getWhoSubscribes().getId());
        subscriptionInfoDto.setFriendId(entity.getFriend().getId());
        subscriptionInfoDto.setId(entity.getId());
        return subscriptionInfoDto;
    }

    @Override
    public List<SubscriptionInfoDto> entityListToDtoList(List<Subscription> entityList) {
        List<SubscriptionInfoDto> returnedList = new ArrayList<>();
        for (Subscription subscription: entityList) {
            SubscriptionInfoDto subscriptionInfoDto = entityToDto(subscription);
            returnedList.add(subscriptionInfoDto);
        }
        return returnedList;
    }

    @Override
    public Subscription dtoToEntity(SubscriptionInfoDto dto) {
        return null;
    }

    @Override
    public void dtoHasErrors(SubscriptionInfoDto dto) throws WrongArgumentsException {

    }
}
