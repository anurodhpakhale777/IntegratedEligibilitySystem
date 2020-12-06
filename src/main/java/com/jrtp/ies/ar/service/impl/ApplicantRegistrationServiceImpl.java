package com.jrtp.ies.ar.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.jrtp.ies.ar.entity.ApplicantEntity;
import com.jrtp.ies.ar.entity.CitizenResponse;
import com.jrtp.ies.ar.model.Applicant;
import com.jrtp.ies.ar.repository.ApplicantRepository;
import com.jrtp.ies.ar.service.ApplicantRegistrationService;
import com.jrtp.ies.constants.AppConstants;

@Service
public class ApplicantRegistrationServiceImpl implements ApplicantRegistrationService {

	@Autowired
	private ApplicantRepository applicantRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public boolean saveApplicant(Applicant applicant) {
		applicant.setActive(true);
		ApplicantEntity applicantEnt = new ApplicantEntity();
		BeanUtils.copyProperties(applicant, applicantEnt);
		return null != applicantRepo.save(applicantEnt);
	}

	@Override
	public List<Applicant> getAllApplicants() {
		 List<ApplicantEntity> applicantEntList = applicantRepo.findAllByIsActiveTrue();
		 List<Applicant> applicantList = new ArrayList<>();
		 if(null != applicantEntList) {
			 applicantEntList.stream().forEach((applicantEnt) -> {
				 Applicant applicant = new Applicant();
				 BeanUtils.copyProperties(applicantEnt, applicant);
				 applicantList.add(applicant);
			 });
		 }
		 return applicantList;
	}

	@Override
	public Applicant editApplicant(String applicantId) {
		Optional<ApplicantEntity> applicantEntOpt = applicantRepo.findByApplicantId(applicantId);
		Applicant applicant = new Applicant();
		if(applicantEntOpt.isPresent()) {
			BeanUtils.copyProperties(applicantEntOpt.get(), applicant);
		}
		return applicant;
	}

	@Override
	public boolean updateApplicant(Applicant applicant) {
		return saveApplicant(applicant);
	}

	@Override
	public boolean deleteApplicant(String applicantId) {
		return applicantRepo.deleteSoftApplicant(applicantId) > 0;
	}

	@Override
	public String checkValidSsn(Integer ssn) {
		String endPointUrl = "http://localhost:7070/verify/{ssn}";
		//String retrivedSsn = restTemplate.getForEntity(url, CitizenResponse.class, ssn);
		ResponseEntity<CitizenResponse> responseEntity = null;
		String response = null;
		CitizenResponse citizen = null;
		try {
			responseEntity = restTemplate.getForEntity(endPointUrl, CitizenResponse.class, ssn);
			//citizen = restTemplate.getForObject(endPointUrl, CitizenResponse.class, ssn);
			if(responseEntity.getStatusCode()==HttpStatus.OK) {
				citizen = responseEntity.getBody();
				if("Kentucky".equals(citizen.getStateName())) {
					response = AppConstants.VALID_CITIZEN;
				}else
					response = AppConstants.IN_VALID_CITIZEN;
			}else if(responseEntity.getStatusCode()==HttpStatus.NO_CONTENT){
				response = AppConstants.IN_VALID_SSN;
			}
		}catch(ResourceAccessException ex) {
			ex.printStackTrace();
			response = AppConstants.SSAWEB_CONN_FAIL;
		}catch(Exception ex) {
			ex.printStackTrace();
			response = AppConstants.UNDEFINED_ERRMSG;
		}
		return response;
	}

}
