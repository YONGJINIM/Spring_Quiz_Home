package com.quiz.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.entity.RecruitEntity;
import com.quiz.lesson07.repository.RecruitRepository;

@RestController
@RequestMapping("/lesson07/quiz02")
public class Lesson07Quiz02RestController {

	@Autowired
	private RecruitRepository recruitRepository;
	
	// http://localhost:8080/lesson07/quiz02/1
	@GetMapping("/1")
	public RecruitEntity idSelect_1() { // 단건
		return recruitRepository.findById(8);
	}
	// http://localhost:8080/lesson07/quiz02/2?companyId=2
	@GetMapping("/2")
	public List<RecruitEntity> idSelect_2(
			@RequestParam("companyId") int companyId
			) {
		return recruitRepository.findByCompanyId(companyId);
	}
	
}
