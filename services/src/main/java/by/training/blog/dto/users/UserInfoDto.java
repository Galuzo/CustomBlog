package by.training.blog.dto.users;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.deser.Deserializers;

import java.util.Date;

/**
 * Created by Win on 28.06.2017.
 */
public class UserInfoDto extends Deserializers.Base {
    private String firstName;
    private String lastName;
    private String role;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastOnline;

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getLastOnline() {
        return lastOnline;
    }

    public void setLastOnline(Date lastOnline) {
        this.lastOnline = lastOnline;
    }
}
