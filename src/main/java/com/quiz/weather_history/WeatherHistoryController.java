package com.quiz.weather_history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.bo.WeatherHistoryBO;
import com.quiz.weather_history.domain.WeatherHistory;

@RequestMapping("/weather-history") // 공통 경로 => /weather-history
@Controller // 자바 빈 등록
public class WeatherHistoryController {
	
	@Autowired // 의존성 주입
	private WeatherHistoryBO weatherHistoryBO;

	// 목록 화면
	// /weather-history/weather-list-view
	@GetMapping("/weather-list-view")
	public String weatherListView(Model model) {
		
		// DB Select
		List<WeatherHistory> weatherHistoryList = weatherHistoryBO.getWeatherHistoryList();
		
		// model에 담기
		model.addAttribute("weatherHistoryList", weatherHistoryList);
		
		return "weather_history/weatherList";
	}
	
	// 추가 화면
	// /weather-history/add-weather-view
	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		return "weather_history/addWeather";
	}
	
	// DB에 저장 => 목록 화면
	// /weather-history/add-weather
	@PostMapping("/add-weather")
	public String addWeather( // WeatherHistory weatherHistory
			@RequestParam("date") String date, // localdate로 받는게 제일 베스트
			@RequestParam("weather") String weather,
			@RequestParam("microDust") String microDust,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("windSpeed") double windSpeed						
			) {
	// http:servletResponse response / void로 하고
		
	// db insert
		
	// 목록화면으로 이동 (redirect) 
	return "redirect:/weather-history/weather-list-view";
		
		
	}
	
}
