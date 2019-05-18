package com.madbarsoft.doctorchamber.vital;

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
@Table(name = "vital", uniqueConstraints = {@UniqueConstraint(columnNames = {"doctor_no", "name"})})
public class VitalEntity  extends BaseEntity implements Serializable{
	
   private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NonNull private Long id;

	@NotNull
    @Column(name = "name")
    private String vitalName;

    @Column(name = "unit")
    private String vitalUnit;
    
    @Column(name = "default_value")
    private String defaultValue;

	@NotNull
    @Column(name = "serial")
    private Long vitalSerial;
	
	@NotNull
    @Column(name = "input_type", columnDefinition = "int default 1")
    private int inputType;             // 1 for type= "text", 2 for textarea


	@NotNull
    @Column(name = "doctor_no")
    private Long doctorNo;
	
    @Column(name = "is_enable")
    private Boolean  isEnable;



}
