package com.jrtp.ies.dc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrtp.ies.admin.plans.repositories.PlanRepository;
import com.jrtp.ies.ar.entity.ApplicantEntity;
import com.jrtp.ies.ar.model.Applicant;
import com.jrtp.ies.ar.repository.ApplicantRepository;
import com.jrtp.ies.ar.service.ApplicantRegistrationService;
import com.jrtp.ies.constants.AppConstants;
import com.jrtp.ies.dc.entity.CaseDetailEntity;
import com.jrtp.ies.dc.entity.CasePlanEntity;
import com.jrtp.ies.dc.entity.ChildCareEntity;
import com.jrtp.ies.dc.entity.EducationEntity;
import com.jrtp.ies.dc.entity.IncomeDetailEntity;
import com.jrtp.ies.dc.model.CaseDetail;
import com.jrtp.ies.dc.model.CasePlan;
import com.jrtp.ies.dc.model.ChildDetail;
import com.jrtp.ies.dc.model.EducationDetail;
import com.jrtp.ies.dc.model.IncomeDetail;
import com.jrtp.ies.dc.repository.CasePlanRepository;
import com.jrtp.ies.dc.repository.CaseRepository;
import com.jrtp.ies.dc.repository.ChildCareRepository;
import com.jrtp.ies.dc.repository.EducationRepository;
import com.jrtp.ies.dc.repository.IncomeDetailRepository;
import com.jrtp.ies.dc.service.DataCollectionService;

@Service
public class DataCollectionServiceImpl implements DataCollectionService {

	@Autowired
	private ApplicantRepository applicantRepo;
	
	@Autowired
	private PlanRepository planRepo;
	
	@Autowired
	private CaseRepository caseRepo;
	
	@Autowired
	private CasePlanRepository casePlanRepo;
	
	@Autowired
	private IncomeDetailRepository incomeDetRepo;

	@Autowired
	private ChildCareRepository childRepo;
	
	@Autowired
	private EducationRepository educationRepo;
	
	@Autowired
	private ApplicantRegistrationService applicationRegServ;
	
	@Override
	public Applicant getApplicantDetails(String applicantId) {
		Optional<ApplicantEntity> applicantDetOpt = applicantRepo.findByApplicantId(applicantId);
		Applicant applicant = null;
		if(applicantDetOpt.isPresent()) {
			applicant = new Applicant();
			BeanUtils.copyProperties(applicantDetOpt.get(), applicant);
		}
		return applicant;
	}

	@Override
	public boolean saveCaseDetails(CaseDetail caseDet) {
		CaseDetailEntity caseDetEnt = new CaseDetailEntity();
		BeanUtils.copyProperties(caseDet, caseDetEnt);
		CaseDetailEntity savedEnt = caseRepo.save(caseDetEnt);
		return null != savedEnt ? true : false;
	}

	@Override
	public List<String> getAllPlanNames() {
		return planRepo.findAllPlanNames();
	}

	@Override
	public boolean saveCasePlanDetails(CasePlan casePlan) {
		CasePlanEntity casePlanEnt = new CasePlanEntity();
		BeanUtils.copyProperties(casePlan, casePlanEnt);
		CasePlanEntity savedEnt = casePlanRepo.save(casePlanEnt);
		return null != savedEnt ? true : false;
	}

	@Override
	public boolean saveIncomeDetails(IncomeDetail incomeDet) {
		IncomeDetailEntity incomeDetEnt = new IncomeDetailEntity();
		BeanUtils.copyProperties(incomeDet, incomeDetEnt);
		IncomeDetailEntity savedEnt = incomeDetRepo.save(incomeDetEnt);
		return null != savedEnt ? true : false;
	}

	@Override
	public boolean saveChildCareDetails(ChildDetail childDet) {
		ChildCareEntity childEnt = new ChildCareEntity();
		BeanUtils.copyProperties(childDet, childEnt);
		ChildCareEntity savedEnt = childRepo.save(childEnt);
		return null != savedEnt ? true : false;
	}

	@Override
	public List<ChildDetail> getAllChildDetails() {
		 List<ChildCareEntity> childEntList = childRepo.findAll();
		 List<ChildDetail> childDetList = new ArrayList<>();
		 if(null != childEntList) {
			 childEntList.stream().forEach((childEnt) -> {
				 ChildDetail childDet = new ChildDetail();
				 BeanUtils.copyProperties(childEnt, childDet);
				 childDetList.add(childDet);
			 });
		 }
		 return childDetList;
	}

	@Override
	public ChildDetail editChildDetails(Integer childId) {
		Optional<ChildCareEntity> childEntOpt = childRepo.findById(childId);
		ChildDetail childDet = new ChildDetail();
		if(childEntOpt.isPresent()) {
			BeanUtils.copyProperties(childEntOpt.get(), childDet);
		}
		return childDet;
	}

	@Override
	public boolean updateChildDetails(ChildDetail childDet) {
		return saveChildCareDetails(childDet);
	}

	@Override
	public boolean deleteChildDetails(Integer childId) {
		return childRepo.deleteSoftChildDetails(childId) > 0;
	}

	@Override
	public boolean isChildSsnValid(Integer ssn) {
		String validStr =  applicationRegServ.checkValidSsn(ssn);
		if(validStr.equals(AppConstants.VALID_CITIZEN))
			return true;
		else
			return false;
	}

	@Override
	public boolean saveEducationDetails(EducationDetail educationDet) {
		EducationEntity educationEnt = new EducationEntity();
		BeanUtils.copyProperties(educationDet, educationEnt);
		EducationEntity savedEnt = educationRepo.save(educationEnt);
		return null != savedEnt ? true : false;
	}

}
