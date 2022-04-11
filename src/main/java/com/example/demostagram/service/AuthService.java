package com.example.demostagram.service;

import com.example.demostagram.domain.user.User;
import com.example.demostagram.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service //1.IOC 2.트랜잭션 관리
public class AuthService {

    private final UserRepository userRepository;
                            //통신을 통해 받은 데이터
    public User 회원가입(User user){
        //회원가입 진행
             //DB에서 받은 데이터를 받음
       User userEntity = userRepository.save(user);
        return userEntity;
    }
}
