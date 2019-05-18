package com.madbarsoft.doctorchamber.generic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.madbarsoft.doctorchamber.base.BaseRepository;
import com.madbarsoft.doctorchamber.brand.BrandEntity;
import com.madbarsoft.doctorchamber.group.GroupEntity;
import com.madbarsoft.doctorchamber.group.GroupService;
import com.madbarsoft.doctorchamber.util.Def;
import com.madbarsoft.doctorchamber.util.Response;

@Repository
@Transactional
public class GenericRepository extends BaseRepository {
	
	
	public Response list(String obj) {    
	    GenericEntity  genericEntity = new GenericEntity();
	    if(obj!=null) {
			JSONObject jsonObj = Def.getJSONObject(obj);
		    Long groupNo =  Def.getLong(jsonObj, "groupNo");	    
		    if(groupNo!=null) {
			    genericEntity.setGroup(new GroupEntity(groupNo));
		    } 
	    }
        return baseList(criteriaQuery(genericEntity));
    }
	
	public Response save(String obj) {
		JSONObject jsonObj = Def.getJSONObject(obj);
		Long groupNo =  Def.getLong(jsonObj, "groupNo");
	    GenericEntity genericEntity = objectMapperReadValue(jsonObj.toString(), GenericEntity.class);
	    genericEntity.setGroup(new GroupEntity(groupNo));
	
		return baseOnlySave(genericEntity);
	}
	
	
	public Response update(String obj) {
		
			JSONObject jsonObj = Def.getJSONObject(obj);
			Long groupNo =  Def.getLong(jsonObj, "groupNo");
		    GenericEntity genericEntity = objectMapperReadValue(jsonObj.toString(), GenericEntity.class);
		    genericEntity.setGroup(new GroupEntity(groupNo));
		    
		    genericEntity.setModifiedDate(new Date());
	   	 
	       	 return baseUpdate(genericEntity);
	      
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(GenericEntity filter) {
		initEntityManagerBuilderCriteriaQueryRoot(GenericEntity.class);
		CriteriaBuilder builder = super.builder; 
		CriteriaQuery criteria = super.criteria;
		Root root = super.root; 
		
		List<Predicate> p = new ArrayList<Predicate>();
		
		if (filter != null) {
			if (filter.getActiveStatus() > 0) {
				Predicate condition = builder.equal(root.get("activeStatus"), filter.getActiveStatus());
				p.add(condition);
			}

			if (filter.getId() != null &&  filter.getId() > 0) {
				Predicate condition = builder.equal(root.get("id"), filter.getId());
				p.add(condition);
			}
			
			if (filter.getGroup() != null) {
				Predicate condition = builder.equal(root.get("group"), filter.getGroup() );
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
	
	public  GenericEntity findById(Long id) {
		GenericEntity obj = new GenericEntity();
		obj.setId(id);
	    Response  response =  baseFindById(criteriaQuery(obj));
	    if(response.isSuccess()) {
	    return 	(GenericEntity) response.getObj();
	    }
	   return null;
	}
	

	
	public Response detele(Long id) {
		GenericEntity obj = findById(id);
		return baseDelete(obj);
		
	}

}
