package com.jrtp.ies.batch;

import com.jrtp.ies.ed.model.CorrespondenceTrigger;

public interface BatchProcess {

	Integer preProcess(Integer caseId);
	void start();
	void process(CorrespondenceTrigger corrTrigger);
	void postProcess(Integer batchRunSeq);
}
