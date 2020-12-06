package com.jrtp.ies.dc.model;

import com.jrtp.ies.ar.model.Applicant;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CaseDetail extends Applicant {

	private short caseId;
}
