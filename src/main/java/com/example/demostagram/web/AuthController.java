package com.example.demostagram.web;

import com.example.demostagram.domain.user.User;
import com.example.demostagram.handler.ex.CustomValidationException;
import com.example.demostagram.service.AuthService;
import com.example.demostagram.web.dto.auth.SignupDto;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor //final 필드를 DI할때 사용
@Controller
public class AuthController {

   private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
   private final AuthService authService;

   /**
    * DIA에서 불러올때
    * 1. @AutoWired 를 사용 2. AuthController의 생성자를 만들기
    * 생성자를 만드는 이유 객체를 생성하기 위해서는 생성자를 실행시켜야 한다.
    * 전역변수에 final을 붙이면 무조건 생성자가 실행된다. 혹은 객체가 만들어질때 초기화를 꼭 해야함
    * 3. final + @RequiredArgsConstructor 롬복 어노테이션을 사용
    */
//   public AuthController (AuthController authController){
//       this.authService = authService;
//   }


   @GetMapping("/auth/signin")
    public String signinForm(){
        return "auth/signin";
    }

    @GetMapping("/auth/signup")
    public String signupForm(){
        return "auth/signup";
    }

    //회원가입 버튼 -> auth/signup -> auth/signin
    @PostMapping("/auth/signup")                                //valid에서 생긴 에러를 bindiingResult에 모은다
    public String signup(@Valid SignupDto signupDto, BindingResult bindingResult){

       if (bindingResult.hasErrors()){
           Map<String, String> errorMap = new HashMap<>();

           //for문 돌리면서 에러를 담기
           for (FieldError error : bindingResult.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
               System.out.println(error.getDefaultMessage());
           }
           throw new CustomValidationException("유효성 검사 실패", errorMap);

       }else {
           User user = signupDto.toEntity();
           User userEntity = authService.회원가입(user);
           System.out.println(userEntity);
       }

        return "auth/signin";
    }

}
