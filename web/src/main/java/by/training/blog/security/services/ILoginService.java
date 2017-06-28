package by.training.blog.security.services;

/**
 * Created by Win on 28.06.2017.
 */
public interface ILoginService {
    void authenticate(String email, String password);
}
