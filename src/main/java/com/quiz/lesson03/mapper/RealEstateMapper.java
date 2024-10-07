package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {
	
	// input : id(int)
	// output : RealEstate(DTO)
	public RealEstate selectRealEstateById(int id);

	// input : rentPrice(Integer)
	// output : List<RealEstate>
	public List<RealEstate> selectRealEstateListByRentPrice(Integer  rentPrice);

	// input :  area(int), price(int)
	// output : List<RealEstate>
	public List<RealEstate> selectRealEstateListByAreaPrice(
			// 파라미터를 두개 이상 xml에 보낼 수 없다. 
			// 하나의 맵으로 구성해야 하는데, @Param이 맵으로 만들어준다.
			// Param("") <= 는 xml의 #{}와 연결
			@Param("area") int area, 
			@Param("price") int price);
	
	// input : RealEstate 
	// output : int 
	public int insertRealEstate(RealEstate realEstate);
	
	// input : 파라미터
	// output : int 
	public int insertRealEstateAsField(
			@Param("realtorId") int realtorId,
			@Param("address") String address,
			@Param("area") int area,
			@Param("type") String type,
			@Param("price") int price,
			@Param("rentPrice") Integer rentPrice);
}
