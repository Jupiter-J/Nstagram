package com.example.demostagram.domain.Subsribe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface SubscribeRepository extends JpaRepository<Subscribe, Long> {


    @Modifying // INSERT, DELETE, UPDATE 를 네이티브 쿼리로 작성하려면 해당 어노테이션 필요!!
    @Query(value = "INSERT INTO subscribe(fromUserId, toUserId) VALUES(:fromUserId, :toUserId)", nativeQuery = true)
    void mSubscribe(Long fromUserId, Long toUserId);

    @Modifying
    @Query(value = "DELETE FROM subscribe WHERE fromUserId = :fromUserId AND toUserId = :toUserId", nativeQuery = true)
    void mUnSubscribe(Long fromUserId, Long toUserId);

//    @Query(value = "SELECT COUNT(*) FROM subscribe WHERE fromUserId = :principalId AND toUserId = :pageUserId", nativeQuery = true)
//    int mSubscribeState(int principalId, int pageUserId);
//
//    @Query(value = "SELECT COUNT(*) FROM subscribe WHERE fromUserId = :pageUserId", nativeQuery = true)
//    int mSubscribeCount(int pageUserId);

}
