//import by.training.blog.dto.users.UserForCreateDto;
//import by.training.blog.entities.User;
//import by.training.blog.exceptions.ServiceException;
//import by.training.blog.interfaces.ISubscriptionService;
//import by.training.blog.interfaces.IUserDao;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import javax.transaction.Transactional;
//
//import java.util.GregorianCalendar;
//import java.util.List;
//
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//
///**
// * Created by Win on 24.06.2017.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:service-context-test.xml")
//@Transactional
//@Rollback(false)
//public class SubscriptionsServiceTest {
//    @Autowired
//    private ISubscriptionService followerService;
//
//    @Autowired
//    private IUserDao userDao;
//    private final String TEST = "TEST";
//    private User user;
//    @Before
//    public void setUp() {
//        user = saveTestingUser();
//    }
//
//
//
//
//
//    @Test
//    public void addFriendShouldBeSuccessful() throws ServiceException {
//        User friend = saveTestingUser();
//        followerService.subscribe(user.getId(),friend.getId());
//        assertNotNull(user.getSubscriptions().contains(friend));
//    }
//
//    @Test(expected = ServiceException.class)
//    public void addFriendShouldThrowsException() throws ServiceException {
//        followerService.subscribe(user.getId(),-1);
//    }
//
//    @Test
//    public void deleteFriendShouldBeSuccessful() throws ServiceException {
//        User friend = saveTestingUser();
//        followerService.subscribe(user.getId(),friend.getId());
//        followerService.unsubscribe(user.getId(),friend.getId());
//        assertFalse(user.getSubscriptions().contains(friend));
//    }
//
//    @Test(expected = ServiceException.class)
//    public void deleteFriendShouldThrowsException() throws ServiceException {
//        followerService.unsubscribe(user.getId(),-5);
//    }
//
//    @Test
//    public void deleteAllFriends() throws ServiceException {
//        User friend = saveTestingUser();
//        followerService.subscribe(user.getId(),friend.getId());
//        followerService.unsubscribeFromAll(user.getId());
//        assertTrue(user.getSubscriptions().isEmpty());
//    }
//
//    private UserForCreateDto createUserForCreateDto() {
//        UserForCreateDto userForCreateDto = new UserForCreateDto();
//        userForCreateDto.setEmail(TEST);
//        userForCreateDto.setFirstName(TEST);
//        userForCreateDto.setLastName(TEST);
//        userForCreateDto.setPassword(TEST);
//        return userForCreateDto;
//    }
//
//    private User saveTestingUser() {
//        User user = new User();
//        user.setLastName(TEST);
//        user.setPassword(TEST);
//        user.setEmail(TEST);
//        user.setFirstName(TEST);
//        user.setDateOfSignUp(GregorianCalendar.getInstance().getTime());
//        user.setLastOnline(GregorianCalendar.getInstance().getTime());
//        int id= userDao.save(user);
//        return userDao.getById(id);
//    }
//
//    @After
//    public void cleanAll() {
//        List<User> list=userDao.getAll();
//        for (User user : list) {
//            userDao.delete(user.getId());
//        }
//    }
//
//}
