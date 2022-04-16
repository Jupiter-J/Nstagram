package com.example.demostagram.service;

import com.example.demostagram.domain.Subsribe.Subscribe;
import com.example.demostagram.domain.Subsribe.SubscribeRepository;
import com.example.demostagram.handler.ex.CustomApiException;
import com.example.demostagram.web.dto.subsribe.SubscribeDto;
import lombok.RequiredArgsConstructor;
import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SubscribeService {

    private final SubscribeRepository subscribeRepository;
    private final EntityManager em; // Repository는 EntityManager를 구현해서 만들어져 있는 구현체

    @Transactional(readOnly = true)
    public List<SubscribeDto> 구독리스트 (Long principalId, Long pageUserId) {

        //쿼리 준비
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT u.id, u.username, u.profileImageUrl, ");
        sb.append("if ((SELECT 1 FROM subscribe WHERE fromUserId = ? AND toUserId = u.id), 1, 0) subscribeState, ");
        sb.append("if ((?=u.id), 1, 0) equalUserState ");
        sb.append("FROM user_community u INNER JOIN subscribe s ");
        sb.append("ON u.id = s.toUserId ");
        sb.append("WHERE s.fromUserId = ?"); //세미콜론 사용하면 안됨

        // 물음표 (?) = principalId
        // 물음표 (?) = principalId
        // 물음표 (?) = pageUserId

        //쿼리 완성
        Query query = em.createNativeQuery(sb.toString())
                .setParameter(1, principalId)
                .setParameter(2, principalId)
                .setParameter(3, pageUserId);

        //쿼리 실행 : qlrm = DB 결과 가져와서 자바 클래스에 매핑 -> DTO로 가져옴
        JpaResultMapper result = new JpaResultMapper();
        List<SubscribeDto> subscribeDtoList = result.list(query, SubscribeDto.class);
        return subscribeDtoList;
    }




    @Transactional //데이터 추가, 갱신, 삭제 등으로 이루어진 작업을 처리하던 중 오류가 발생했을 때 모든 작업들을 원상태로 되돌릴 수 있다
    public void 구독하기(Long fromUserid, Long toUserid){
        try {
            subscribeRepository.mSubscribe(fromUserid, toUserid);
        }catch (Exception e){
            throw new CustomApiException("이미 구독하였습니다 ");
        }
    }

    @Transactional
    public void 구독취소하기(Long fromUserid, Long toUserid){
        subscribeRepository.mUnSubscribe(fromUserid, toUserid);

    }


}
