package com.example.demostagram.domain.user;

import com.example.demostagram.domain.image.Image;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

//JPA - Java Persistence API (자바로 데이터를 영구적으로 저장(DB)할수 있는 API를 제공)
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_community")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 20,unique = true) //제약조건의 하나로 해당 컬럼에 동일한 값이 들어가지 않도록 하는 제약조건
    private String username;
    @Column(nullable = false) //필수 입력
    private String password;
    @Column(nullable = false)
    private String name;

    private String website; //웹사이트
    private String bio;  //자기소개

    @Column(nullable = false)
    private String email;
    private String phone;
    private String gender;

    private String profileImageUrl; //사진
    private String role; //권한

    //한명의 유저는 여러개의 이미지를 올릴 수 있다 (이미지 클래스의 user)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY) //1. 연관관계의 주인이 아니다. 테이블의 칼럼을 만들지 않는다.
    @JsonIgnoreProperties({"user"})
    private List<Image> images;                           //2. User를 select할때 해당 user id로 등록된 image들을 다 가져와


    private LocalDateTime createData;

    //DB에 현재 시간을 저장
    @PrePersist  //DB에 insert되기 직전에 실행
    public void createData(){  //현재시간을 주입하는 함수 생성
        this.createData = LocalDateTime.now();
    }

}
