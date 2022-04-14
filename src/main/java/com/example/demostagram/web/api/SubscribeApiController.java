package com.example.demostagram.web.api;

import com.example.demostagram.config.auth.PrincipalDetails;
import com.example.demostagram.domain.Subsribe.SubscribeRepository;
import com.example.demostagram.service.SubscribeService;
import com.example.demostagram.web.dto.CMRespDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class SubscribeApiController {
    private static final Logger logger = LoggerFactory.getLogger(SubscribeApiController.class);
    private final SubscribeService subscribeService;

    @GetMapping("/api/subscribe/{toUserId}")
    public String test(@PathVariable Long toUserId) {
        return "실행됌";
    }


    @PostMapping("/api/subscribe/{toUserId}")
    public ResponseEntity<?> subscribe(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable Long toUserId) {
        subscribeService.구독하기(principalDetails.getUser().getId(), toUserId);
        logger.info("실행됌");
        return new ResponseEntity<>(new CMRespDto<>(1, "구독 성공", null), HttpStatus.OK);
    }

    @DeleteMapping ("/api/subscribe/{toUserId}")
    public ResponseEntity<?> unSubscribe(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable Long toUserId) {
        subscribeService.구독취소하기(principalDetails.getUser().getId(), toUserId);
        logger.info("실행됌");
        return new ResponseEntity<>(new CMRespDto<>(1, "구독 취소 성공", null), HttpStatus.OK);
    }



}
