package com.example.demostagram.web.dto.auth;

import com.example.demostagram.domain.user.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data //Getter Setter
public class SignupDto {

    private String username;
    private String password;
    private String email;
    private String name;

    public User toEntity(){
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .name(name)
                .build();
    }

}
