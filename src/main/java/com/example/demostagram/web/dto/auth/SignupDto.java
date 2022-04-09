package com.example.demostagram.web.dto.auth;

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



}
