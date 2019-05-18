package com.madbarsoft.doctorchamber.group;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.madbarsoft.doctorchamber.base.BaseRepository;
import com.madbarsoft.doctorchamber.util.Response;

@Repository
@Transactional
public class GroupRepository extends BaseRepository{

	public Response save(GroupEntity reqObj) {
		return baseOnlySave(reqObj);
	}

public Response update(GroupEntity reqObj) {
	GroupEntity obj  = findById(reqObj.getId());
    	
     if(obj !=null) {
    	 
    		obj.setGroupName(reqObj.getGroupName());
        
   	 
       	 return baseUpdate(obj);
       	 
       	}
    	
      return getErrorResponse("Record not Found !!");

}




public Response detele(Long id) {
	
	GroupEntity brand = findById(id);
	return baseDelete(brand);
	
}

public Response remove(Long id) {
	GroupEntity brand = findById(id);
	brand.setActiveStatus(3);
	return baseRemove(brand);
}

public Response list(GroupEntity reqObj) {
    
    return baseList(criteriaQuery(reqObj));
}

public  GroupEntity findById(Long id) {
	GroupEntity groupEntity = new GroupEntity();
	groupEntity.setId(id);
    Response  response =  baseFindById(criteriaQuery(groupEntity));
    if(response.isSuccess()) {
    return 	(GroupEntity) response.getObj();
    }
   return null;
}

@SuppressWarnings({ "rawtypes", "unchecked" })
private CriteriaQuery criteriaQuery(GroupEntity filter) {
	initEntityManagerBuilderCriteriaQueryRoot(GroupEntity.class);
	CriteriaBuilder builder = super.builder; 
	CriteriaQuery criteria = super.criteria;
	Root root = super.root; 
	
	List<Predicate> p = new ArrayList<Predicate>();


	
	if (filter != null) {
		if (filter.getActiveStatus() > 0) {
			Predicate condition = builder.equal(root.get("activeStatus"), filter.getActiveStatus());
			p.add(condition);
		}

		if (filter.getId() !=null && filter.getId() > 0) {
			Predicate condition = builder.equal(root.get("id"), filter.getId());
			p.add(condition);
		}

		if (filter.getDoctorNo() != null && filter.getDoctorNo() > 0) {
			Predicate condition = builder.equal(root.get("doctorNo"), filter.getDoctorNo());
			p.add(condition);
		}
	}
	
	

	if (!CollectionUtils.isEmpty(p)) {
		Predicate[] pArray = p.toArray(new Predicate[] {});
		Predicate predicate = builder.and(pArray);
		criteria.where(predicate);
	}

	return criteria;

}
}
