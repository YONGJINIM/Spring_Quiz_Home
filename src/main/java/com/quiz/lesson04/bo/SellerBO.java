package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Seller;
import com.quiz.lesson04.mapper.SellerMapper;

@Service  // 이 클래스가 서비스 레이어에서 동작하는 Spring의 서비스 컴포넌트임을 나타냄
public class SellerBO {

    @Autowired  // 의존성 주입을 통해 SellerMapper 객체를 주입받음
    private SellerMapper sellerMapper;

    // 판매자 정보를 받아서 데이터베이스에 저장하는 메소드
    public void addSeller(
            String nickname,  // 추가할 판매자의 닉네임
            String profileImageUrl,  // 추가할 판매자의 프로필 이미지 URL
            Double temperature) {  // 추가할 판매자의 온도 (신뢰도)

        // 받은 판매자 정보를 DB에 삽입하기 위해 매퍼의 insertSeller 메소드를 호출
        sellerMapper.insertSeller(nickname, profileImageUrl, temperature);
    }
    
    public Seller getLatestSeller() {
    	return sellerMapper.selectLatestSeller();
    }
    
    public Seller getSellerById(int id) {
    	return sellerMapper.selectSellerById(id);
    }
}
