package com.madbarsoft.doctorchamber.authentication;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.madbarsoft.doctorchamber.base.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="core_user")
public class UserEntity extends BaseEntity {
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long id;
		
		@Column(name="USER_NAME",nullable = false)
	    private String userName;
		
		@Column(nullable = true)
		private String name;
		
		@Column(name="full_name",nullable = true)
		private String fullName;
		
		@Column(name="phone",nullable = true)
		private String phone;
		
		@Column(nullable = false)
		private String email;
		
		@Column(nullable = false)
		private String password;
		
		@Column(nullable = true)
		private Date dateOfBirth;
		
		@Column(nullable = true)
		private String gender;
		
/*		@Column(nullable = false)
		private int activeStatus = 1;*/
		
		@Column(name="enabled",  nullable = false)
		private boolean enabled;
		
		@Column(name="account_locked",  nullable = false)
		private boolean accountLocked;
		
		@Column(name="account_expired",  nullable = false)
		private boolean accountExpired;
		
		@Column(name="password_expired",  nullable = false)
		private boolean passwordExpired;

		@Column(name="account_expire_date",  nullable = true)
		private  Date accountExpireDate;
		
		@Column(name="agent_id",  nullable = true)
		private Long agentId;
		
		@Column(name="company_id",  nullable = true)
		private Long companyId;
		
/*		@Column(nullable = true, name = "date_created")
		private Date dateCreated = new Date();*/

	/*	@Column(nullable = false, name = "created_by")
		private String createdBy;*/

/*		@Column(nullable = true, name = "last_updated")
		private Date lastUpdated;*/
/*
		@Column(nullable = true, name = "updated_by")
		private String updatedBy;*/
		
		@Column(nullable = true, name = "company_name")
		private String companyName;
	
	}