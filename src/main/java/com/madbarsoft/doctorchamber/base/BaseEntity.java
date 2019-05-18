package com.madbarsoft.doctorchamber.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
abstract public class BaseEntity  {

	@CreatedDate
    @Column(name="created_date")
    private Date createdDate = new Date();
	
    @CreatedBy
    @Column(name="created_by")
    private String createdBy;
    
    @LastModifiedDate
    @Column(name="modified_date")
    private Date modifiedDate;
    
    @LastModifiedBy
    @Column(name="modified_by")
    private String modifiedBy;
    
    @Column(name="active_status",nullable = false)
    private int activeStatus = 1; // 1 for active, 2 for inactive, 3 for remove

  
}

