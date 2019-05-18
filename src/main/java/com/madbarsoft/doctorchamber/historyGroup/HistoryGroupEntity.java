package com.madbarsoft.doctorchamber.historyGroup;

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
@Table(name = "history_group")
public class HistoryGroupEntity  extends BaseEntity implements Serializable{
	
   private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NonNull private Long id;

	@NotNull
	@Column(name = "group_name")
	private String groupName;
	
	@NotNull
    @Column(name = "serial")
    private Long serial;

	@NotNull
    @Column(name = "doctor_no")
    private Long doctorNo;
    
    @Column(name = "is_show_header")
    private Boolean  isShowHeader = true;
	
    @Column(name = "is_enable")
    private Boolean  isEnable;
     
}
