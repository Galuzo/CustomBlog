package by.training.blog.dto.users;

import by.training.blog.dto.BaseDto;

/**
 * Created by Win on 28.06.2017.
 */
public class UserForLoginDto extends BaseDto {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
