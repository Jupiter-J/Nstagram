package com.example.demostagram.domain.image;

import com.example.demostagram.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String caption; //상태글
    private String postImageUrl; //사진을 전송받아서 그 사진을 서버에 특정 폴더에 저장

    @JoinColumn(name = "userId")
    @ManyToOne // 유저 한명이 여러개의 사진을 올릴수 있다
    private User user;

    //이미지 좋아요

    //댓글


    private LocalDateTime createData;
    @PrePersist
    public void createData(){  //현재시간을 주입하는 함수 생성
        this.createData = LocalDateTime.now();
    }

    //오브젝트를 콘솔에 출력할 때 문제가 될 수 있어서 User부분을 출력되지 않게 함
//    @Override
//    public String toString() {
//        return "Image{" +
//                "id=" + id +
//                ", caption='" + caption + '\'' +
//                ", postImageUrl='" + postImageUrl + '\'' +
//                ", createData=" + createData +
//                '}';
//    }
}
