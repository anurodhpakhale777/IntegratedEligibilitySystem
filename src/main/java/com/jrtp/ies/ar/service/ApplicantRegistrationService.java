package com.jrtp.ies.ar.service;

import java.util.List;

import com.jrtp.ies.ar.model.Applicant;

public interface ApplicantRegistrationService {

	boolean saveApplicant(Applicant applicant);
	List<Applicant> getAllApplicants();
	Applicant editApplicant(String ApplicantId);
	boolean updateApplicant(Applicant applicant);
	boolean deleteApplicant(String applicantId);
	String checkValidSsn(Integer ssn);
}
