package com.madbarsoft.doctorchamber.physicalExamination;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.madbarsoft.doctorchamber.base.BaseEntity;
import com.madbarsoft.doctorchamber.physicalExamGroup.PhysicalExamGroupEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Md. Jahurul Islam
 *
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "physical_examination", uniqueConstraints = {@UniqueConstraint(columnNames = {"doctor_no", "exam_name"})})
public class PhysicalExaminationEntity  extends BaseEntity implements Serializable{
	
   private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NonNull private Long id;

	@NotNull
    @Column(name = "exam_name")
    private String examName;

    @Column(name = "exam_unit")
    private String examUnit;

    @Column(name = "exam_serial")
    private Long examSerial;

	@NotNull
    @Column(name = "doctor_no")
    private Long doctorNo;
	
	
	@NotNull
    @Column(name = "input_type")
    private int inputType = 1;             // 1 for type= "text", 2 for textarea
	
    @Column(name = "is_show_header")
    private Boolean  isShowHeader = true;
	
    @Column(name = "is_enable")
    private Boolean  isEnable;
       
    @ManyToOne(optional = false)
	@JoinColumn(name = "exam_group_id")
	private PhysicalExamGroupEntity examGroup;
    
    

}
