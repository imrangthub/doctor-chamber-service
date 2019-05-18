package com.madbarsoft.doctorchamber.doctorWisePscrip;

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
@Table(name = "doctor_wise_pscrip")
public class DoctorWisePscripEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull
	@Column(name = "id")
	private Long id;

	@NotNull
	@Column(name = "doctor_id")
	private String doctorId;
	
	@NotNull
	@Column(name = "doctor_no")
	private Long doctorNo;
	
    @Column(name = "is_enable")
    private Boolean  isEnable;

    @OneToOne
	@JoinColumn(name = "pres_peport_id")
	private PresReportEntity presReportEntity;
    
    @OneToOne
 	@JoinColumn(name = "pres_form_id")
 	private PresFormEntity presFormEntity;


}
