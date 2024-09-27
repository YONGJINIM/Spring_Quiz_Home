package com.quiz.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lesson01/quiz02")
public class Lesson01Quiz02RestController {

	// http://localhost:8080/lesson01/quiz02/1
	@RequestMapping("/1")
	public List<Map<String, Object>> quiz02_1 () {
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();	
		
	      map.put("rate", 15);
	      map.put("director", "봉준호");
	      map.put("time", 131);
	      map.put("title", "기생충");
	      list.add(map);
	      
	      map = new HashMap<>();
	      map.put("rate", 0);
	      map.put("director", "로베르토 베니니");
	      map.put("time", 116);
	      map.put("title", "인생은 아름다워");
	      list.add(map);
	      
	      map = new HashMap<>();
	      map.put("rate", 12);
	      map.put("director", "크리스토퍼 놀란");
	      map.put("time", 147);
	      map.put("title", "인셉션");
	      list.add(map);
	      
	      map = new HashMap<>();
	      map.put("rate", 19);
	      map.put("director", "윤종빈");
	      map.put("time", 133);
	      map.put("title", "범죄와의 전쟁");
	      list.add(map);
	      
	      map = new HashMap<>();
	      map.put("rate", 15);
	      map.put("director", "프란시스 로렌스");
	      map.put("time", 137);
	      map.put("title", "헝거게임");
	      list.add(map);
	      
	      return list;
	   }   	
		
		// http://localhost:8080/lesson01/quiz02/2
		@RequestMapping("/2")
		public List<Border> quiz02_2() {
			List<Border> list = new ArrayList<>(); 
			// @ResponseBody + return String => HttpMessageConverter => HTML
			// @ResponseBody + return => HttpMessageConverter => Jackson lib => JSON
			
			Border border = new Border();
			border.setTitle("안녕하세요 가입인사 드립니다.");
			border.setUser("marobiana");
			border.setContent("안녕하세요. 가입했어요 앞으로도 잘 부탁드립니다.");
			list.add(border);
			
			border = new Border();
			border.setTitle("헐 대박");
			border.setUser("bada");
			border.setContent("오늘 목요일이였어...금요일인줄");
			list.add(border);
			
			border = new Border();
			border.setTitle("오늘 데이트 한 이야기 해드릴게요!");
			border.setUser("dulumary");
			border.setContent("...");
			list.add(border);
			
			return list; //JSON response body
		}
		// http://localhost:8080/lesson01/quiz02/3
		@RequestMapping("/3")
		public ResponseEntity<Border> quiz02_3() {
			Border border = new Border();
			
			border.setTitle("안녕하세요 가입인사 드립니다.");
			border.setUser("marobiana");
			border.setContent("안녕하세요. 가입했어요 앞으로도 잘 부탁드립니다."); 
			
			return new ResponseEntity<>(border,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
}
