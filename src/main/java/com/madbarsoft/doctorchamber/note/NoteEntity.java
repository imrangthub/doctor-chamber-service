package com.madbarsoft.doctorchamber.note;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.madbarsoft.doctorchamber.base.BaseEntity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Md. Jahurul Islam
 *
 */
@Getter
@Setter
@Entity
@Table(name="note")
 public class  NoteEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NonNull private Long id;

	@NotNull
    @Column(name = "name")
    private String noteName;
	
	@NotNull
	@Column(nullable = false, name = "description", length = 4000)
    private String noteDescription;
	
    @Column(name = "doctor_no")
    private Long doctorNo;
	

}
