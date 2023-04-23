package com.example.rsue3labs.settings.forms;

import com.example.rsue3labs.settings.models.MyUser;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public MyUser toUser(PasswordEncoder passwordEncoder) {
        return new MyUser(
                username, passwordEncoder.encode(password), fullname);
    }
}
