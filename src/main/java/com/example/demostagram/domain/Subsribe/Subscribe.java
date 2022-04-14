package com.example.demostagram.domain.Subsribe;

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
@Table(
        name = "subscribe",
        uniqueConstraints = {
                @UniqueConstraint(
                        name="subscribe_uk",
                        columnNames = {"fromUserId", "toUserId"}
                )
        }
)
public class Subscribe {
    /**
     * 구독(팔로우)기능은 다대다 매핑
     * */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "fromUserId")
    @ManyToOne
    private User fromUser; //구독 하는 유저

    @JoinColumn(name = "toUserId")
    @ManyToOne
    private User toUser; //구독 받는 유저

    private LocalDateTime createData;

//    @PrePersist
//    public void createData(){  //현재시간을 주입하는 함수 생성
//        this.createData = LocalDateTime.now();
//    }





}
