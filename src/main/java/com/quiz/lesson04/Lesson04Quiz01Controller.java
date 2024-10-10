package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;

@Controller  // 이 클래스가 Spring MVC의 컨트롤러임을 나타냄
@RequestMapping("/lesson04/quiz01")  // 이 컨트롤러의 기본 URL 매핑을 설정
public class Lesson04Quiz01Controller {

    @Autowired  // SellerBO 객체를 주입받음 (의존성 주입)
    private SellerBO sellerBO;
    
    // http://localhost:8080/lesson04/quiz01/add-seller-view
    @RequestMapping(path = "/add-seller-view", method = RequestMethod.GET)  // GET 방식으로 add-seller-view 요청을 처리
    public String addSellerView() {
        // 판매자 추가 화면을 반환
        return "lesson04/addSeller";
    }
    
    @PostMapping("/add-seller")  // POST 방식으로 add-seller 요청을 처리
    public String addSeller(
            @RequestParam("nickname") String nickname,  // 요청 파라미터로 nickname을 받음
            @RequestParam("profileImageUrl") String profileImageUrl,  // 요청 파라미터로 profileImageUrl을 받음
            @RequestParam("temperature") Double temperature) {  // 요청 파라미터로 temperature를 받음
    
        // 받은 정보를 통해 sellerBO의 addSeller 메소드를 호출하여 판매자 정보를 DB에 저장
        sellerBO.addSeller(nickname, profileImageUrl, temperature); 
        
        // 판매자 추가 후 이동할 뷰를 반환
        return "lesson04/afterAddSeller";  
    }
}
