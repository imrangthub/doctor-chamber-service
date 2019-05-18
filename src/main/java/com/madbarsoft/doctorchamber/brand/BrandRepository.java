package com.madbarsoft.doctorchamber.brand;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
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
import com.madbarsoft.doctorchamber.generic.GenericEntity;
import com.madbarsoft.doctorchamber.generic.GenericService;
import com.madbarsoft.doctorchamber.group.GroupEntity;
import com.madbarsoft.doctorchamber.manufacturer.ManufacturerEntity;
import com.madbarsoft.doctorchamber.note.NoteEntity;
import com.madbarsoft.doctorchamber.util.Def;
import com.madbarsoft.doctorchamber.util.Response;
import com.madbarsoft.doctorchamber.vital.VitalEntity;

@Repository
@Transactional
public class BrandRepository extends BaseRepository{
	
	@Autowired
	GenericService genericService;

	
	public Response list(String obj) {    
		BrandEntity  brandEntity = new BrandEntity();
		
		
		if(obj !=null && !obj.toString().equals("{}")) {
			
			JSONObject jsonObj = Def.getJSONObject(obj);
		    Long genericNo =  Def.getLong(jsonObj, "genericNo");

		    brandEntity.setGeneric(new GenericEntity(genericNo));
			
		}

	    
        return baseList(criteriaQuery(brandEntity));
    }

	public Response save(String reqObj) {
		
		JSONObject jsonObj = Def.getJSONObject(reqObj);
		Long genericNo =  Def.getLong(jsonObj, "genericNo");
		BrandEntity brandEntity = (BrandEntity)objectMapperReadValue(jsonObj.toString(), BrandEntity.class);
		brandEntity.setGeneric(new GenericEntity(genericNo));
		
			if(brandEntity.getId()!=null) {
			    return baseSaveOrUpdate(brandEntity);
			}
	   
	    return baseOnlySave(brandEntity);
		}
	
	public Response update(BrandEntity reqObj) {
		BrandEntity obj  = findById(reqObj.getId());
	    	
	     if(obj !=null) {
	    	 
	    		obj.setBrandName(reqObj.getBrandName());
	        	obj.setForm(reqObj.getForm());
	        	obj.setStrength(reqObj.getStrength());
	        	obj.setMap_no(reqObj.getMap_no());
	        	obj.setPrice(reqObj.getPrice());
	        	obj.setPreferred(reqObj.getPreferred());
	        	obj.setGeneric(reqObj.getGeneric());
	        	obj.setManufacturer(reqObj.getManufacturer());
	   	 
	       	 return baseUpdate(obj);
	       	 
	       	}
	    	
	      return getErrorResponse("Record not Found !!");
	}
	
	public Response detele(Long id) {
		
		BrandEntity brand = findById(id);
		return baseDelete(brand);
		
	}
	
	public Response remove(Long id) {
		BrandEntity brand = findById(id);
		brand.setActiveStatus(3);
		return baseRemove(brand);
	}

	public  BrandEntity findById(Long id) {
		BrandEntity brandEntity = new BrandEntity();
		brandEntity.setId(id);
        Response  response = baseFindById(criteriaQuery(brandEntity));
        if(response.isSuccess()) {
        return 	(BrandEntity) response.getObj();
        }
       return null;
    }

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(BrandEntity filter) {
		initEntityManagerBuilderCriteriaQueryRoot(BrandEntity.class);
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
			if (filter.getGeneric() != null) {
				Predicate condition = builder.equal(root.get("generic"), filter.getGeneric() );
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
