package com.example.demostagram.web;

import com.example.demostagram.config.auth.PrincipalDetails;
import com.example.demostagram.domain.user.User;
import com.example.demostagram.service.UserService;
import com.example.demostagram.web.dto.user.UserProfileDto;
import lombok.RequiredArgsConstructor;
import org.dom4j.rule.Mode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{pageUserId}")
    public String profile(@PathVariable long pageUserId, Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        UserProfileDto dto = userService.회원프로필(pageUserId, principalDetails.getUser().getId());
        model.addAttribute("dto", dto);
        return "user/profile";
    }



    @GetMapping("/user/{id}/update")
    public String update(@PathVariable long id , @AuthenticationPrincipal PrincipalDetails principalDetails){
        //1. 추천
//        System.out.println("세션정보: " + principalDetails.getUser());

        //2. 비추천
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println("직접찾은 세션정보: " + auth.getPrincipal());
        return "user/update";
    }

}
