package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@Controller  // 이 클래스가 Spring MVC의 컨트롤러임을 나타냄
@RequestMapping("/lesson04/quiz01")  // 이 컨트롤러의 기본 URL 매핑을 설정
public class Lesson04Quiz01Controller {

    @Autowired  // SellerBO 객체를 주입받음 (의존성 주입)
    private SellerBO sellerBO;
    
    // 회원가입 페이지 
    // http://localhost:8080/lesson04/quiz01/add-seller-view
    @GetMapping("/add-seller-view")  // GET 방식으로 add-seller-view 요청을 처리
    public String addSellerView() {
        // 판매자 추가 화면을 반환
        return "lesson04/addSeller";
    }
    
    // DB에 저장 => 입력 성공 페이지 이동
    // lesson04/quiz01/add-seller
    @PostMapping("/add-seller")  // POST 방식으로 add-seller 요청을 처리
    public String addSeller(
            @RequestParam("nickname") String nickname,  // 요청 파라미터로 nickname을 받음 (필수 파라미터)
            @RequestParam(value = "profileImageUrl" , required = false) String profileImageUrl,  // 요청 파라미터로 profileImageUrl을 받음 (DB 확인 Null 허용 비필수)
            @RequestParam(value = "temperature" , defaultValue = "36.5" ) double temperature) {  // 요청 파라미터로 temperature를 받음 (DB 확인 Null 허용 비필수 , defaultValue 36.5 설정)  
    
    	// TODO ‘아직 해결되지 않은 작업이나 구현해야 할 부분’을 나타내는 주석 태그      
    	// DB insert (받은 정보를 통해 sellerBO의 addSeller 메소드를 호출하여 판매자 정보를 DB에 저장)
        sellerBO.addSeller(nickname, profileImageUrl, temperature); 
        
        // 판매자 추가 완료 이후 이동할 뷰를 반환
        return "lesson04/afterAddSeller";  // 값이 잘 들어왔는지 브레이크 포인트 걸어서 확인 함
    }
    // 최근 가입자 화면
    // http://localhost:8080/lesson04/quiz01/seller-info-view
    // http://localhost:8080/lesson04/quiz01/seller-info-view?id=3
    @GetMapping("/seller-info-view")
    public String sellerInfoView(
    		@RequestParam(value = "id" , required = false) Integer id,// null이 가능하기 때문에 Integer 사용
    		Model model) {
    	
    	// DB 최근 사용자 조회(Select) 브레이크 포인트 걸어서 확인
    	// id가 null이면 최신, id가 있으면 id로 
    	
    	Seller seller = null; 
    	if (id == null) {
    		seller = sellerBO.getLatestSeller();    		
    	} else {
    		seller =  sellerBO.getSellerById(id);
    	}
    	  	  	
    	// Model에서 담음 
    	model.addAttribute("Seller", seller);
    	model.addAttribute("title", "판매자 정보");
    	   	
    	return "lesson04/sellerInfo";
    }
    
}
