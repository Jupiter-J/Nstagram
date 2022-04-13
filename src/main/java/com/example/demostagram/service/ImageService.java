package com.example.demostagram.service;

import com.example.demostagram.config.auth.PrincipalDetails;
import com.example.demostagram.domain.image.Image;
import com.example.demostagram.domain.image.ImageRepository;
import com.example.demostagram.web.dto.image.ImageUploadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ImageService {

    private final ImageRepository imageRepository;

    @Value("${file.path}")
    private String uploadFolder;

    @Transactional
    public void 사진업로드(ImageUploadDto imageUploadDto, PrincipalDetails principalDetails){
        /**
         * 같은 파일이 올라오면 덮어씌어진다. 파일을 받아서 구분하기 위함 UUID
         * UUID : 네트워크 상에서 고유성이 보장되는 id를 만들기 위한 표준 규약
         * */

        UUID uuid = UUID.randomUUID();
        String imageFileName = uuid+"_"+imageUploadDto.getFile().getOriginalFilename();
        System.out.println("이미지파일이름: " + imageFileName);


        Path imageFilePath = Paths.get(uploadFolder+imageFileName);
        //통신, I/O -> 예외가 발생할 수 있다
        try {
            Files.write(imageFilePath, imageUploadDto.getFile().getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }

        //이미지를 테이블에 저장
        Image image = imageUploadDto.toEntity(imageFileName,principalDetails.getUser());
        imageRepository.save(image);
//        System.out.println(imageEntity.toString());

    }

}
