package com.example.demostagram.service;

import com.example.demostagram.domain.Subsribe.SubscribeRepository;
import com.example.demostagram.domain.user.User;
import com.example.demostagram.domain.user.UserRepository;
import com.example.demostagram.handler.ex.CustomException;
import com.example.demostagram.handler.ex.CustomValidationApiException;
import com.example.demostagram.handler.ex.CustomValidationException;
import com.example.demostagram.web.dto.user.UserProfileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final SubscribeRepository subscribeRepository;

    @Value("${file.path}")
    private String uploadFolder;

    @Transactional(readOnly = true)
    public UserProfileDto 회원프로필(long pageUserId, long principalId) {
        UserProfileDto dto = new UserProfileDto();

        // SELECT * FROM image WHERE userId = :userId;
        User userEntity = userRepository.findById(pageUserId).orElseThrow(() -> {
            // throw -> return 으로 변경
            return new CustomException("해당 프로필 페이지는 없는 페이지입니다.");
        });

        dto.setUser(userEntity);
        dto.setPageOwnerState(pageUserId == principalId);
        dto.setImageCount(userEntity.getImages().size());
        return dto;
    }

    @Transactional
    public User 회원수정(long id, User user) {
        // 1. 영속화
        // 1. 무조건 찾았다. 걱정마 get()
        // 2. 못찾았어 익섹션 발동시킬께 orElseThrow()
        User userEntity = userRepository.findById(id).orElseThrow(() -> {
            return new CustomValidationApiException("찾을 수 없는 id입니다.");});

        // 2. 영속화된 오브젝트를 수정 - 더티체킹 (업데이트 완료)
        userEntity.setName(user.getName());

        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);

        userEntity.setPassword(encPassword);
        userEntity.setBio(user.getBio());
        userEntity.setWebsite(user.getWebsite());
        userEntity.setPhone(user.getPhone());
        userEntity.setGender(user.getGender());
        return userEntity;
    }
    // 더티체킹이 일어나서 업데이트가 완료됨.


}
