package by.training.blog.security.details;

import by.training.blog.entities.User;
import by.training.blog.interfaces.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Win on 28.06.2017.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private IUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.getByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("No user with such email: " + email);
        } else {
            return new CustomUserDetails(user);
        }
    }
}
