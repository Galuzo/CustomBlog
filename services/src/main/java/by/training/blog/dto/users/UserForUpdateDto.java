package by.training.blog.dto.users;

import by.training.blog.dto.BaseDto;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by Win on 20.06.2017.
 */
public class UserForUpdateDto extends BaseDto{
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastOnline;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateOfSignUp;
    private int roleId;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastOnline() {
        return lastOnline;
    }

    public void setLastOnline(Date lastOnline) {
        this.lastOnline = lastOnline;
    }

    public Date getDateOfSignUp() {
        return dateOfSignUp;
    }

    public void setDateOfSignUp(Date dateOfSignUp) {
        this.dateOfSignUp = dateOfSignUp;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
