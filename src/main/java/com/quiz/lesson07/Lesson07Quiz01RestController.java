package com.quiz.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.bo.CompanyBO;
import com.quiz.lesson07.entity.CompanyEntity;

@RestController
@RequestMapping("/lesson07/quiz01")
public class Lesson07Quiz01RestController {

	@Autowired
	private CompanyBO companyBO;
	
	// C : Create
	@GetMapping("/save1") //  클라이언트가 요청하는 URL 경로
	public CompanyEntity save1() { // save1(): 메서드 이름은 Spring MVC의 요청 처리 로직 내에서 사용하는 내부적인 식별자로, URL 경로와는 아무 상관이 없다.
			String name = "넥슨";
			String business= "컨텐츠 게임";
			String scale = "대기업";
			int headcount = 3585;
		
		// addCompany() 메서드를 호출해서 데이터를 삽입하고 그 결과를
		return companyBO.addCompany(name, business, scale, headcount);
	}
	@GetMapping("/save2")
	public CompanyEntity save2() {
		return companyBO.addCompany("버블팡", "여신금융업", "중소기업", 34);
	}
	// Update
	@GetMapping("/update")
	public CompanyEntity update() {
		// id가 8번인 회사의 scale, headCount를 변경하고자 한다.
		return companyBO.updateCompanyById(8, "중소기업", 34);
	}
	// Delete 
	@GetMapping("/delete")
	public String delete() {
		companyBO.deleteCompanyById(8);
		return "삭제완료";
	}
}
