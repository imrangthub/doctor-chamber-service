package com.madbarsoft.doctorchamber.prescriptionHistory;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.madbarsoft.doctorchamber.base.BaseEntity;
import com.madbarsoft.doctorchamber.history.HistoryEntity;
import com.madbarsoft.doctorchamber.historyGroup.HistoryGroupEntity;
import com.madbarsoft.doctorchamber.prescription.PrescriptionEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "history_prescription_data")
public class PrescriptionHistoryEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Column(name = "history_name")
	private String historyName;

	@Column(name = "history_place_holder")
	private String historyPlaceHolder;

	@Column(name = "history_result", length = 4000)
	private String historyResult;

	@Column(name = "exam_data_type")
	private int historyDataType;

	@Transient
	private Integer isDeleted;

	@Column(nullable = false, name = "is_bold", length = 1)
	private Integer isBold = 0;

	@Column(nullable = false, name = "in_report_serial")
	private Integer inReportSerial = 0;

	@ManyToOne(optional = true)
	@JoinColumn(name = "history_id")
	private HistoryEntity history;

	@ManyToOne(optional = false)
	@JoinColumn(name = "history_group_id")
	private HistoryGroupEntity historyGroup;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "prescription_no", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private PrescriptionEntity prescription;

	
}
