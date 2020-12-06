package com.jrtp.ies.admin.accounts.models;

import java.util.Date;

import lombok.Data;

@Data
public class UserAccount {
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private Date dateOfBirth;
	
	private String gender;
	
	private String emailId;
	
	private long phoneNo;
	
	private String password;
	
	private String role;
	
	private boolean isActive;
	
}
