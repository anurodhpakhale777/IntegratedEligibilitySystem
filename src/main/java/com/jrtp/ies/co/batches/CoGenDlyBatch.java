package com.jrtp.ies.co.batches;

import java.sql.SQLDataException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jrtp.ies.co.entity.BatchRunDetailEntity;
import com.jrtp.ies.co.model.BatchRunDetail;
import com.jrtp.ies.co.repository.BatchRunDetailRepository;
import com.jrtp.ies.ed.entity.CorrespondenceTriggerEntity;
import com.jrtp.ies.ed.model.CorrespondenceTrigger;
import com.jrtp.ies.ed.repository.CorrespondenceTriggerRepository;

@Component
public class CoGenDlyBatch {

	@Autowired
	private BatchRunDetailRepository batchRunDtlRepo;
	
	@Autowired
	private CorrespondenceTriggerRepository corrTrgRepo;
	
	private CorrespondenceTrigger corrTrg;
	
	public void preProcess(BatchRunDetail batchRunDtl) throws SQLDataException {
		batchRunDtl.setStartDate(new Date());
		BatchRunDetailEntity batchRunEnt = new BatchRunDetailEntity();
		BeanUtils.copyProperties(batchRunDtl, batchRunEnt);
		if(batchRunDtlRepo.save(batchRunEnt) != null) {
			throw new SQLDataException();
		};
	}
	
	public void start() {
		List<CorrespondenceTriggerEntity> corrTrgEntList = corrTrgRepo.findAllByTriggerStatus('P');
		corrTrgEntList.forEach(corrTrgEnt -> {
			corrTrg = new CorrespondenceTrigger();
			BeanUtils.copyProperties(corrTrgEnt, corrTrg);
			execute();
		});
	}
	
	public void execute() {
		// TODO Auto-generated method stub

	}
	
	public void postProcess(BatchRunDetail batchRunDtl) throws SQLDataException {
		batchRunDtl.setEndDate(new Date());
		BatchRunDetailEntity batchRunEnt = new BatchRunDetailEntity();
		BeanUtils.copyProperties(batchRunDtl, batchRunEnt);
		if(batchRunDtlRepo.save(batchRunEnt) != null) {
			throw new SQLDataException();
		};
	}
}
