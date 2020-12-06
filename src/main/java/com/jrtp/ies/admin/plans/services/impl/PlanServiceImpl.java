package com.jrtp.ies.admin.plans.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrtp.ies.admin.plans.entity.PlanEntity;
import com.jrtp.ies.admin.plans.models.Plan;
import com.jrtp.ies.admin.plans.repositories.PlanRepository;
import com.jrtp.ies.admin.plans.services.PlanService;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanRepository planRepo;
	
	@Override
	public boolean savePlan(Plan plan) {
		plan.setActive(true);
		PlanEntity planEnt = new PlanEntity();
		BeanUtils.copyProperties(plan, planEnt);
		return null != planRepo.save(planEnt);
	}

	@Override
	public List<Plan> getAllPlans() {
		List<PlanEntity> planEntList = planRepo.findAllByIsActiveTrue();
		List<Plan> planList = new ArrayList<Plan>();
		 if(null != planEntList) {
			 planEntList.stream().forEach((planEnt) -> {
				 Plan plan = new Plan();
				 BeanUtils.copyProperties(planEnt, plan);
				 planList.add(plan);
			 });
		 }
		 return planList;
	}

	@Override
	public Plan editPlan(Integer planId) {
		Optional<PlanEntity> planEntOpt = planRepo.findById(planId);
		Plan plan = new Plan();
		if(planEntOpt.isPresent()) {
			BeanUtils.copyProperties(planEntOpt.get(), plan);
		}
		return plan;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		return savePlan(plan);
	}

	@Override
	public boolean deletePlan(Integer planId) {
		return planRepo.softDeletePlan(planId) > 0 ;
	}

}
