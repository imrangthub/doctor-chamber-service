package com.madbarsoft.doctorchamber.app_user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.madbarsoft.doctorchamber.base.BaseEntity;
import com.madbarsoft.doctorchamber.presForm.PresFormEntity;
import com.madbarsoft.doctorchamber.presReport.PresReportEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_user")
public class AppUserEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull
	@Column(name = "id")
	private Long id;

	@NotNull
	@Column(name = "user_id")
	private String userId;
	
	@NotNull
	@Column(name = "password")
	private String password;
	
	@Column(name = "user_no")
	private Long userNo;
	
	
	@Column(name = "emp_name")
	private String empName;
	
    @Column(name = "is_doctor")
    private Boolean  isDoctor;
    

	@Column(name = "report_link")
	private Long reportLink = 2l;
	
	@Column(name = "form_link")
	private String formLink;
	

}
