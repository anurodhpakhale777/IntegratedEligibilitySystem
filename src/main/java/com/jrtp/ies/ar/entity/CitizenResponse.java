package com.jrtp.ies.ar.entity;

import java.sql.Blob;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@JsonRootName("citizen")
public class CitizenResponse {

	private String firstName;
	private String lastName;
	private String gender;
	private Date dateOfBirth;
	private String stateName;
	private Blob image;
	private Long socialSecurityNo;
}
