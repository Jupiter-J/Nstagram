package com.example.demostagram.web.dto;

import com.example.demostagram.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CMRespDto<T> {
    private int code;
    private String message;
    private T data;

}
