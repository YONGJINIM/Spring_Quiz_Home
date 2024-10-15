package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.domain.Realtor;

import ch.qos.logback.core.joran.spi.ConsoleTarget;

@Controller // 스프링 빈 등록 
@RequestMapping("/lesson04/quiz02") // 공통 경로
public class Lesson04Quiz02Controller {

	@Autowired //의존성 주입
	private RealtorBO realtorBO;
	
	// 공인중개사 추가 화면  
	// http://localhost:8080/lesson04/quiz02/add-realtor-view
	@GetMapping("/add-realtor-view")
	public String addRealtorView() {
		return "lesson04/addRealtor";
	}

	// 공인중개사 추가 => 최신 가입자 화면
	@PostMapping("/add-realtor")
	public String addRealtor(@ModelAttribute Realtor realtor,
			Model model) {
		
		// DB Insert
		realtorBO.addRealtor(realtor);
		
		// DB Select
		Realtor latestRealtor = realtorBO.selectRealtorById(realtor.getId()); 
		
		// Model		
		model.addAttribute("realtor", latestRealtor);
		
		// View 화면 
		return "lesson04/afterAddRealtor";
	}	
}
