package com.madbarsoft.doctorchamber.history;

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
import com.madbarsoft.doctorchamber.historyGroup.HistoryGroupEntity;

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
@Table(name = "history", uniqueConstraints = {@UniqueConstraint(columnNames = {"doctor_no", "history_name"})})
public class HistoryEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@NonNull
	private Long id;

	@NotNull
	@Column(name = "history_name")
	private String historyName;

	@Column(name = "history_place_holder")
	private String historyPlaceHolder;

	@Column(name = "history_serial")
	private Long historySerial;

	@NotNull
	@Column(name = "doctor_no")
	private Long doctorNo;
	
	@NotNull
    @Column(name = "input_type")
    private int inputType = 1;             // 1 for type= "text", 2 for textarea

	@Column(name = "is_enable")
	private Boolean isEnable;
	
    @Column(name = "is_show_header")
    private Boolean  isShowHeader = true;
    
    @ManyToOne(optional = false)
	@JoinColumn(name = "history_group_id")
	private HistoryGroupEntity historyGroup;

}
