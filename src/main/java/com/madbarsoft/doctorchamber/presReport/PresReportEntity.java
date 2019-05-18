package com.madbarsoft.doctorchamber.presReport;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.madbarsoft.doctorchamber.base.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pres_report")
public class PresReportEntity extends BaseEntity implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull
    @Column(name = "id")
    private Long id;

	@NotNull
    @Column(name = "report_name")
    private String reportName;
	
	@NotNull
    @Column(name = "report_link")
    private String reportLink;
	
}


