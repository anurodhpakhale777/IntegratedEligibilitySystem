package com.jrtp.ies.co.batches;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jrtp.ies.admin.plans.entity.PlanEntity;
import com.jrtp.ies.admin.plans.models.Plan;
import com.jrtp.ies.admin.plans.repositories.PlanRepository;
import com.jrtp.ies.batch.BatchProcess;
import com.jrtp.ies.co.entity.BatchRunDetailEntity;
import com.jrtp.ies.co.entity.CoPdfEntity;
import com.jrtp.ies.co.repository.BatchRunDetailRepository;
import com.jrtp.ies.co.repository.CoPdfRepository;
import com.jrtp.ies.dc.entity.CaseDetailEntity;
import com.jrtp.ies.dc.model.CaseDetail;
import com.jrtp.ies.dc.repository.CaseRepository;
import com.jrtp.ies.ed.entity.CorrespondenceTriggerEntity;
import com.jrtp.ies.ed.entity.EligibilityDetailsEntity;
import com.jrtp.ies.ed.model.CorrespondenceTrigger;
import com.jrtp.ies.ed.model.EligibilityDetails;
import com.jrtp.ies.ed.repository.CorrespondenceTriggerRepository;
import com.jrtp.ies.ed.repository.EligibilityDetailsRepository;

@Component
public class CoGenDlyBatch implements BatchProcess{

	@Autowired
	private BatchRunDetailRepository batchRunDtlRepo;
	
	@Autowired
	private CorrespondenceTriggerRepository corrTrgRepo;
	
	@Autowired
	private EligibilityDetailsRepository eligibilityDtlRepo;
	
	@Autowired
	private CaseRepository caseRepo;
	
	@Autowired
	private PlanRepository planRepo;
	
	@Autowired
	private CoPdfRepository coPdfRepo;
	
	@Override
	public Integer preProcess(Integer caseId) {
		BatchRunDetailEntity batchRunEnt = new BatchRunDetailEntity();
		batchRunEnt.setBatchName(getClass().getName());
		batchRunEnt.setBatchRunStatus("Pending");
		batchRunEnt.setStartDate(new Date());
		BatchRunDetailEntity savedEnt = batchRunDtlRepo.save(batchRunEnt);
		if(savedEnt != null) {
			return savedEnt.getBatchRunSeq();
		}
		return -1;
	}

	@Override
	public void start() {
		List<CorrespondenceTriggerEntity> corrTrgEntList = corrTrgRepo.findAllByTriggerStatus('P');
		corrTrgEntList.forEach(corrTrgEnt -> {
			CorrespondenceTrigger corrTrg = new CorrespondenceTrigger();
			BeanUtils.copyProperties(corrTrgEnt, corrTrg);
			process(corrTrg);
		});
	}
	
	@Override
	public void process(CorrespondenceTrigger corrTrigger) {
		Integer caseId = corrTrigger.getCaseId();
		if(caseId != null) {
			EligibilityDetails eligibilityDtl = getEligibilityData(caseId);
			CaseDetail caseDet = getCitizenData(caseId);
			Plan plan = getPlanInformation(eligibilityDtl.getPlanName());
			
			//generate pdfs
			if(null != eligibilityDtl) {
				if("AP".equals(eligibilityDtl.getPlanStatus())){
					PlanStatusPdfReportGeneration.buildPlanApPdf(eligibilityDtl);
				}else {
					PlanStatusPdfReportGeneration.buildPlanDnPdf(eligibilityDtl);
				}
			}
			
			//store pdf in database
			if(null != eligibilityDtl) {
				CoPdfEntity coPdfEnt = new CoPdfEntity();
				coPdfEnt.setCaseId(eligibilityDtl.getCaseId());
				coPdfEnt.setPlanName(eligibilityDtl.getPlanName());
				coPdfEnt.setPlanStatus(eligibilityDtl.getPlanStatus());
				try {
					FileInputStream fis = new FileInputStream("D:\\AshokIt\\11-JRTPWorkspace\\IntregatedEligibitySystem\\CO_PDFS\\" + eligibilityDtl.getCaseId() + ".pdf");
					byte[] pdfBytes = null;
					IOUtils.readFully(fis, pdfBytes);
					coPdfEnt.setPdfDocument(pdfBytes);
				} catch (IOException e) {
					e.printStackTrace();
				}
				CoPdfEntity savedEnt = coPdfRepo.save(coPdfEnt);
			}else {
				System.out.println("EligibilityDetails object is null");
			}
		}else {
			System.out.println("case-id is null");
		}
		
		
	}

	//Read plan_info based on case_num
	private Plan getPlanInformation(String planName) {
		PlanEntity planEnt = planRepo.findByPlanName(planName);
		Plan planDet = new Plan();
		BeanUtils.copyProperties(planEnt, planDet);
		return planDet;
	}

	
	//Read citizen_addrs details based on case_num
	//Read benefit details/denied details based on case_num
	
	//Read citizen details based on case_num
	private CaseDetail getCitizenData(Integer caseId) {
		Optional<CaseDetailEntity> caseDetEntOpt = caseRepo.findById(caseId);
		CaseDetail caseDet = new CaseDetail();
		if(caseDetEntOpt.isPresent()) {
			BeanUtils.copyProperties(caseDetEntOpt.get(), caseDet);
		}
		return caseDet;
	}

	//Read Eligbility data based on case_num
	private EligibilityDetails getEligibilityData(Integer caseId) {
		Optional<EligibilityDetailsEntity> eligibilityDtlEntOpt = eligibilityDtlRepo.findById(caseId);
		EligibilityDetails eligibilityDtl = new EligibilityDetails(); 
		if(eligibilityDtlEntOpt.isPresent()) {
			BeanUtils.copyProperties(eligibilityDtlEntOpt.get(), eligibilityDtl);
		}
		return eligibilityDtl;
	}

	@Override
	public void postProcess(Integer batchRunSeq) {
		Optional<BatchRunDetailEntity> batchRunDtlOpt = batchRunDtlRepo.findById(batchRunSeq);
		if(batchRunDtlOpt.isPresent()) {
			batchRunDtlOpt.get().setBatchRunStatus("Completed");
			batchRunDtlOpt.get().setEndDate(new Date());
		}else {
			System.out.println("BatchRunDetailEntity not found");
		}
	}
}
