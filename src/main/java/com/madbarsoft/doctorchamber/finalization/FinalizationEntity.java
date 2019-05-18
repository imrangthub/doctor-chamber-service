package com.madbarsoft.doctorchamber.finalization;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.madbarsoft.doctorchamber.base.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "finalization", uniqueConstraints = {@UniqueConstraint(columnNames = {"doctor_no", "finalize_name"})})
public class FinalizationEntity  extends BaseEntity implements Serializable{
	
   private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NonNull private Long id;

	@NotNull
	@Column(name = "finalize_name")
	private String finalizeName;

	@Column(name = "finalize_result")
	private String finalizeResult;

    @Column(name = "finalize_place_holder")
    private String finalizePlaceHolder;

    @Column(name = "serial")
    private Long serial;

	@NotNull
    @Column(name = "doctor_no")
    private Long doctorNo;
	
    @Column(name = "is_enable")
    private Boolean  isEnable;
}

