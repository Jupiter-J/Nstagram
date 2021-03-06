package com.example.demostagram.web;

import com.example.demostagram.config.auth.PrincipalDetails;
import com.example.demostagram.handler.ex.CustomApiException;
import com.example.demostagram.handler.ex.CustomValidationException;
import com.example.demostagram.service.ImageService;
import com.example.demostagram.web.dto.image.ImageUploadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RequiredArgsConstructor
@Controller
public class ImageController {

    private final ImageService imageService;

    @GetMapping({"/","/image/stroy"})
    public String story(){
        return "image/story";
    }

    @GetMapping({"/image/popular"})
    public String popular(){
        return "image/popular";
    }

    @GetMapping({"/image/upload"})
    public String upload(){
        return "image/upload";
    }

    @PostMapping("/image")
    public String imageUpload(ImageUploadDto imageUploadDto, @AuthenticationPrincipal PrincipalDetails principalDetails){

      if (imageUploadDto.getFile().isEmpty()){
          throw new CustomValidationException("이미지가 첨부되지 않았습니다", null);
     }

        //서비스 호출
        imageService.사진업로드(imageUploadDto, principalDetails);
        return"redirect:/user/" + principalDetails.getUser().getId();
    }



}
