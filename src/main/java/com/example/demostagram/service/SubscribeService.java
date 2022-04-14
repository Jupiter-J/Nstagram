package com.example.demostagram.service;

import com.example.demostagram.domain.Subsribe.Subscribe;
import com.example.demostagram.domain.Subsribe.SubscribeRepository;
import com.example.demostagram.handler.ex.CustomApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SubscribeService {

    private final SubscribeRepository subscribeRepository;


    @Transactional //데이터 추가, 갱신, 삭제 등으로 이루어진 작업을 처리하던 중 오류가 발생했을 때 모든 작업들을 원상태로 되돌릴 수 있다
    public void 구독하기(long fromUserId, long toUserId){
        try {
            subscribeRepository.mSubscribe(fromUserId, toUserId);
        }catch (Exception e){
            throw new CustomApiException("이미 구독하였습니다 ");
        }
    }

    @Transactional
    public void 구독취소하기(long fromUserId, long toUserId){
        subscribeRepository.mUnSubscribe(fromUserId, toUserId);

    }


}
