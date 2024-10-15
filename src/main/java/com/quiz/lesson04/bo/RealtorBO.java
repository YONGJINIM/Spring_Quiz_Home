package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Realtor;
import com.quiz.lesson04.mapper.RealtorMapper;

@Service
public class RealtorBO {

	@Autowired
	private RealtorMapper realtorMapper;
	
	// input: Reartor (컨트롤러 객체가 => Realtor를 넘겨줌)  
	// output: X 
	
	public void addRealtor(Realtor realtor) {
		realtorMapper.insertRealtor(realtor);
	}
	
	// input: id 
	// output: realtor
	
	public Realtor selectRealtorById(int id) {
		return realtorMapper.selectRealtor(id);
	}
}
