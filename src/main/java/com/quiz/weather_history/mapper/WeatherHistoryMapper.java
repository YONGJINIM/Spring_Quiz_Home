package com.quiz.weather_history.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.weather_history.domain.WeatherHistory;

@Mapper
public interface WeatherHistoryMapper {

	// input: X
	// output: List<WeatherHistory>
	public List<WeatherHistory> selectWeatherHistoryList();
	
	// input: date, weather, temperatures, precipitation, microDust, windSpeed
	// output : int or void
	
	public void insertWeatherHistory(
			@Param("date") String date 
			,@Param("weather") String weather 
			,@Param("temperatures") double temperatures
			,@Param("precipitation") double precipitation
			,@Param("microDust") String microDust
			,@Param("windSpeed") double windSpeed);
}
