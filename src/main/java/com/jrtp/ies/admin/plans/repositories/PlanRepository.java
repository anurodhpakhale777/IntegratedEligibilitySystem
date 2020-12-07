package com.jrtp.ies.admin.plans.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jrtp.ies.admin.plans.entity.PlanEntity;

@Repository
public interface PlanRepository extends JpaRepository<PlanEntity, Integer> {

	List<PlanEntity> findAllByIsActiveTrue();
	
	//for Data Collection module
	@Query("select planName from PlanEntity")
	List<String> findAllPlanNames();
	
	@Transactional
	@Modifying
	@Query("update PlanEntity p set p.isActive = false where p.id = :planId")
	int softDeletePlan(@Param("planId") Integer planId);

	//for CO module
	PlanEntity findByPlanName(String planName);
}
