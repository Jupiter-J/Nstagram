package com.example.demostagram.config.auth;

import com.example.demostagram.domain.user.User;
import com.example.demostagram.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * 1. post로 username, password 들어옴
     * 2. IOC에 있는 UserDetailsSerivce가 두개를 갖고 로그인을 진행
     * 3. PrincipalDetailsSerivce가 덮어쓰운다 (왜? 부모타입으로 userDtailsSerivce와 같음)
     * 4. 최종적으로 PrincipalDetailsSerice에서 로그인을 진행하게됨
     * */
    @Override                                       //스프링시큐리티가 pw는 알아서 비교해서 처리해준다 //로그인은 직접해야함!
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User userEntity = userRepository.findByUsername(username);
        if (userEntity == null){
            return null;
        }else{
            return new PrincipalDetails(userEntity);
        }

    }




}
