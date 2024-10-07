package com.quiz.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.domain.RealEstate;

@RestController // Controller + ResponseBody
@RequestMapping("/lesson03/quiz01")	 // 공통 경로 위로 뺌  
public class Lesson03Quiz01RestController {

	@Autowired // 의존성 주입 
	private RealEstateBO realEstateBO;
	//private RealEstateMapper mapper; 가능은 하지만 코드의 유지보수 때문에 비추

	// http://localhost:8080/lesson03/quiz01/1?id=20
	@RequestMapping("/1")	
	public RealEstate quiz01_1(
			@RequestParam("id") int id){
		return realEstateBO.getRealEstateById(id); // id를 넘겨 줄테니 값을 가져와 
	}
	// http://localhost:8080/lesson03/quiz01/2?rent_price=90
	@RequestMapping("/2")	
	public List<RealEstate> quiz01_2 ( // 여러 건 List로 생성 
		@RequestParam(value = "rent_price") int rentPrice		
			) {
		return realEstateBO.getRealEstateListByRentPrice(rentPrice); 
	}
	// http://localhost:8080/lesson03/quiz01/3?area=90&price=130000
		@RequestMapping("/3")	
		public List<RealEstate> quiz01_3(
			@RequestParam("area") int area,
			@RequestParam("price") int price){
		return	realEstateBO.getRealEstateListByAreaPrice(area, price);
	}
}
