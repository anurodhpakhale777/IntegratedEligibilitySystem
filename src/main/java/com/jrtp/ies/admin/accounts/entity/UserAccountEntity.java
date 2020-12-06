package com.jrtp.ies.admin.accounts.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="USER_ACCOUNT")
public class UserAccountEntity {

	@Id
	@SequenceGenerator(name="user_account_id_seq", allocationSize=1, initialValue=1)
	@GeneratedValue(generator="user_account_id_seq")
	@Column(name="ID")
	private Integer id;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATE_OF_BIRTH")
	private Date dateOfBirth;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="EMAIL_ID")
	private String emailId;
	
	@Column(name="PHONE_NUMBER")
	private long phoneNo;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="ROLE")
	private String role;
	
	@Column(name="IS_ACTIVE", columnDefinition="BOOLEAN default true")
	private boolean isActive = true;
	
	@CreationTimestamp
	@Column(name="CREATION_DATE", updatable=false)
	private Timestamp creationDate;
	
	@UpdateTimestamp
	@Column(name="UPDATION_DATE")
	private Timestamp updationDate;
	
}