package com.jrtp.ies.ed.service;

import com.jrtp.ies.ed.binding.PlanInfo;

public interface EligibilityDeterminationService {

	PlanInfo determineEligibility(Integer caseId);
}
