package com.example.demostagram.web.dto.subsribe;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubscribeDto {

    private BigInteger id;
    private String username;
    private String profileImageUrl;
    private BigInteger subscribeState; //구독 상태
    private BigInteger equalUserState;


}

