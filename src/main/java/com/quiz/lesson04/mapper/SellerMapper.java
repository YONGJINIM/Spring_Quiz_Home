package com.quiz.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper  // MyBatis 매퍼 인터페이스임을 나타냄
public interface SellerMapper {

    // input : 닉네임, 프로필 URL, 온도
    // output : X (리턴값이 없는 삽입 메소드)

    // 판매자 정보를 DB에 삽입하는 메소드
    public void insertSeller(
            @Param("nickname") String nickname,  // DB에 삽입할 판매자의 닉네임
            @Param("profileImageUrl") String profileImageUrl,  // DB에 삽입할 판매자의 프로필 이미지 URL
            @Param("temperature") Double temperature);  // DB에 삽입할 판매자의 온도 (신뢰도)
}
