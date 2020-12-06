package com.jrtp.ies.admin.plans.services;

import java.util.List;

import com.jrtp.ies.admin.plans.models.Plan;

public interface PlanService {

	boolean savePlan(Plan plan);
	List<Plan> getAllPlans();
	Plan editPlan(Integer planId);
	boolean updatePlan(Plan plan);
	boolean deletePlan(Integer planId);
}
