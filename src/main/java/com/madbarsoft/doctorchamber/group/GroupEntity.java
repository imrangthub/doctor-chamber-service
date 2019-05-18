package com.madbarsoft.doctorchamber.group;

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
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "group_table")
public class GroupEntity extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

	@NotNull
    @Column(name = "name")
    private String groupName;

	@NotNull
	@Column(name = "doctor_no")
	private Long doctorNo;

	public GroupEntity() {}
	
	public GroupEntity(Long id) {
		this.id = id;
	}
	

}
