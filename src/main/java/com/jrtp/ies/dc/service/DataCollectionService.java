package com.jrtp.ies.dc.service;

import java.util.List;

import com.jrtp.ies.ar.model.Applicant;
import com.jrtp.ies.dc.model.CaseDetail;
import com.jrtp.ies.dc.model.CasePlan;
import com.jrtp.ies.dc.model.ChildDetail;
import com.jrtp.ies.dc.model.EducationDetail;
import com.jrtp.ies.dc.model.IncomeDetail;

public interface DataCollectionService {

	Applicant getApplicantDetails(String applicantId);
	boolean saveCaseDetails(CaseDetail caseDet);
	List<String> getAllPlanNames();
	boolean saveCasePlanDetails(CasePlan casePlan);
	boolean saveIncomeDetails(IncomeDetail incomeDet);
	boolean saveChildCareDetails(ChildDetail childDet);
	List<ChildDetail> getAllChildDetails();
	ChildDetail editChildDetails(Integer childId);
	boolean updateChildDetails(ChildDetail childDet);
	boolean deleteChildDetails(Integer childId);
	boolean isChildSsnValid(Integer ssn);
	boolean saveEducationDetails(EducationDetail educationDet);
}
