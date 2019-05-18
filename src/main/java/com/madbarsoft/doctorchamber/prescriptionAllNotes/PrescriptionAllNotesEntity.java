package com.madbarsoft.doctorchamber.prescriptionAllNotes;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.madbarsoft.doctorchamber.base.BaseEntity;
import com.madbarsoft.doctorchamber.prescription.PrescriptionEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "prescription_all_notes")
public class PrescriptionAllNotesEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "notes_data_type")
	private int notesDataType;        //   1 for InvestigationNote 4 for MedicineNote

	@Column(name = "notes_data_head")
	private String notesDataHead;

	@Column(nullable = false, name = "notes_data", length = 4000)
	private String notesData;

	@Transient
	private Integer isDeleted;

	@Column(nullable = false, name = "is_bold", length = 1)
	private Integer isBold = 0;

	@ManyToOne(optional = false)
	@JoinColumn(name = "prescription_no", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private PrescriptionEntity prescription;
	
}
