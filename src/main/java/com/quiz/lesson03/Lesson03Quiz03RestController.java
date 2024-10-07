package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;

@RestController
public class Lesson03Quiz03RestController {

	@Autowired
	private RealEstateBO realEstateBO;
	
	// http://localhost:8080/lesson03/quiz03?id=8&type=전세&price=70000
	@RequestMapping("/lesson03/quiz03")
	public String quiz03() {
		
		int rowCount =  realEstateBO.updateRealEstateById(
				8, 
				"전세", 
				70000);

	return "수정 성공" + rowCount;	
	}
}
