package com.quiz.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/quiz01")
@Controller // 이 클래스가 Spring MVC의 컨트롤러임을 선언합니다. 사용자가 보낸 요청을 처리하고 결과를 반환합니다.
public class Lesson01Quiz01Controller {

	@RequestMapping("/1") // "/lesson01/quiz01/1" 경로로 들어오는 요청을 이 메서드가 처리하도록 매핑합니다.
	@ResponseBody // 메서드의 리턴 값을 View가 아닌 HTTP Response Body로 바로 전송합니다. 즉, HTML 형식의 문자열을 그대로 클라이언트에게 보냅니다.
	public String quiz01_1() {
		return "<h2>테스트 프로젝트 완성</h2></h3>"
				+ "해당 프로젝트를 통해서 문제 풀이를 완성합니다.</h3>"; // HTML 형식의 문자열을 클라이언트에게 반환합니다.
	}
	
	@RequestMapping("/2") // "/lesson01/quiz01/2" 경로로 들어오는 요청을 이 메서드가 처리하도록 매핑합니다.
	@ResponseBody // 메서드가 리턴하는 Map 객체를 JSON 형식으로 변환하여 Response Body에 담아 클라이언트에게 전송합니다.
	Map<String, Object> quiz02_2() {
		Map<String, Object> map = new HashMap<>();
		map.put("국어", 80); // 국어 점수 80을 맵에 추가합니다.
		map.put("수학", 90); // 수학 점수 90을 맵에 추가합니다.
		map.put("영어", 85); // 영어 점수 85을 맵에 추가합니다.
		
		return map; // JSON 형식으로 변환되어 클라이언트에게 전송됩니다.
	}
}
