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

@Controller
@RequestMapping("/lesson04/quiz02")
public class Lesson04Quiz02Controller {

	@Autowired
	private RealtorBO realtorBO;
	
	// http://localhost:8080/lesson04/quiz02/add-realtor-view
	@GetMapping("/add-realtor-view")
	public String addRealtorView() {
		return "lesson04/addRealtor";
	}

	@PostMapping("/add-realtor")
	public String addRealtor(@ModelAttribute Realtor realtor,
			Model model) {
		
		// DB Insert
		realtorBO.addRealtor(realtor);
		
		// DB Select
		Realtor latestRealtor = realtorBO.selectRealtorById(realtor.getId()); 
		
		// Model		
		model.addAttribute("realtor", latestRealtor);
		
		
		return "lesson04/afterAddRealtor";
	}	
}
