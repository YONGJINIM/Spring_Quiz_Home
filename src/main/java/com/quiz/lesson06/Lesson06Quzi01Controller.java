package com.quiz.lesson06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lesson06/quiz01")
public class Lesson06Quzi01Controller {

	// 즐겨찾기 추가하기 화면 
	// http://localhost:8080/lesson06/quiz01/add-bookmark-view
	@GetMapping("/add-bookmark-view")
	public String addBookmarkView() {
		return "lesson06/addBookMark";
	}
	
	// 추가 기능 => AJAX 호출
	@ResponseBody
	@PostMapping("/add-bookmark")
	public String addBookmark(
			@RequestParam("name") String name ,
			@RequestParam("url") String url
			) {
		return "성공"; 
	}
		
	
	
	
	
	
}
