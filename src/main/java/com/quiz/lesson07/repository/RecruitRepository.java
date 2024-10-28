package com.quiz.lesson07.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quiz.lesson07.entity.RecruitEntity;

public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer>{

	// RecruitEntity
	public RecruitEntity findById(int id);
	
	// JPQL => Entity에 조회하는 것
	public List<RecruitEntity> findByCompanyId(int companyId);
	
	public List<RecruitEntity> findByPositionContainsAndType(String Position , String Type);

	public List<RecruitEntity> findByTypeOrSalaryGreaterThanEqual(String type, int salary);

	public List<RecruitEntity> findTop3ByTypeOrderBySalaryDesc(String type);
	
	public List<RecruitEntity> findByRegionAndSalaryBetween(String region, int minSalary, int maxSalary);
	 
	// Native Query를 사용한 조회
    @Query(value = "SELECT * FROM recruit " +
                   "WHERE salary >= :salary " +
                   "AND type = :type " +
                   "AND deadline > :deadline " +
                   "ORDER BY salary DESC", nativeQuery = true)
    
    public List<RecruitEntity> findCondition(
        @Param("salary") int salary, 
        @Param("type") String type, 
        @Param("deadline") LocalDate deadline);
}
