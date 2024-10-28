package com.quiz.lesson07;

import java.time.LocalDate;
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
	public RecruitEntity quiz01() { // 단건
		return recruitRepository.findById(8);
	}
	// http://localhost:8080/lesson07/quiz02/2?companyId=2
	@GetMapping("/2")
	public List<RecruitEntity> quiz02(
			@RequestParam("companyId") int companyId
			) {
		return recruitRepository.findByCompanyId(companyId);
	}
	// http://localhost:8080/lesson07/quiz02/3
	@GetMapping("/3")
	public List<RecruitEntity> quiz03() {
		return recruitRepository.findByPositionContainsAndType("back-end","정규직");
	}
	// http://localhost:8080/lesson07/quiz02/4
	@GetMapping("/4")
	public List<RecruitEntity> quiz04() {
		String type = "정규직";
		int salary = 9000;
		// 넘길 인자의 순서가 중요하다. 
		return recruitRepository.findByTypeOrSalaryGreaterThanEqual(type , salary);
	}
	
	/*
	 http://localhost:8080/lesson07/quiz02/5
	 
	 Top3와 같은 키워드는 정렬 조건 이후가 아니라 앞쪽에 와야 합니다. 
	 JPA 메소드 네이밍 규칙에서 예약어의 순서가 정해져 있기 때문입니다. 
	 findTop3By는 반환할 최대 개수를 지정하는 예약어로, 
	 이와 같은 키워드는 메소드 이름의 조건과 정렬 기준보다 앞에 나와야 합니다.
	 
	 */
	@GetMapping("/5")
	public List<RecruitEntity> quiz05(){
		 return recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
	}
	// http://localhost:8080/lesson07/quiz02/6
	@GetMapping("/6")
	public List<RecruitEntity> quiz06() {
		return recruitRepository.findByRegionAndSalaryBetween("성남시 분당구" ,7000,8500);
	}
	// http://localhost:8080/lesson07/quiz02/7
	@GetMapping("/7")
	public List<RecruitEntity> quiz07(){
		
		int salary = 8100;
		String type ="정규직";
		LocalDate deadline = LocalDate.of(2026, 4, 10); // 2026-04-10 이후 조건
		
		// findBySalaryGreaterThanAndTypeAndDeadlineAfterOrderBySalaryDesc
		return recruitRepository.findCondition(salary, type, deadline);
	}
}
