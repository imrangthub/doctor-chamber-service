package com.madbarsoft.doctorchamber.investigation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class InvestigationRepository extends BaseRepository{

	public Response save(InvestigationEntity  reqObj) {
		return baseOnlySave(reqObj);
	}

 public Response update(InvestigationEntity reqObj) {
	InvestigationEntity obj  = findById(reqObj.getId());
    	
     if(obj !=null) {
   	 
       	 return baseUpdate(obj);
       	 
       	}
    	
      return getErrorResponse("Record not Found !!");

}


public Response detele(Long id) {
	
	InvestigationEntity investigation = findById(id);
	return baseDelete(investigation);
	
}

public Response remove(Long id) {
	InvestigationEntity diagnosis = findById(id);
	diagnosis.setActiveStatus(3);
	return baseRemove(diagnosis);
}

public Response list(InvestigationEntity investigation) {
        if(investigation != null ) {
        	investigation.setActiveStatus(1);
        }else {
        	investigation  = new InvestigationEntity();
        	investigation.setDoctorNo(1014567l);
        }
    return oraItemName(baseList(criteriaQuery(investigation)));
}

private Response oraItemName(Response response) {
	 
	 List <InvestigationEntity> investigationEntityList  = null;

	  List<OraInvestigationEntity> oraInvestigationEntityList = new ArrayList<OraInvestigationEntity>();
	    	
	    	OraInvestigationEntity oraInvestigationEntity = new OraInvestigationEntity();

	    	oraInvestigationEntity.setItemId("INV009");
	    	oraInvestigationEntity.setItemTypeNo(10);
	 
	      	oraInvestigationEntity.setItemName("CBC");
	    	oraInvestigationEntity.setDepartmentNo(1002l);
	    	oraInvestigationEntity.setDepartmentName("IMMUNOLOGY");
	    	
	    	
	    	oraInvestigationEntityList.add(oraInvestigationEntity);	
	
	response.setItems(oraInvestigationEntityList);
   
   return getSuccessResponse("Itemd Found",response);

}



public  InvestigationEntity findById(Long id) {
	InvestigationEntity investigation = new InvestigationEntity();
	investigation.setId(id);
	Response  response = baseFindById(criteriaQuery(investigation));
	if(response.isSuccess()) {
		return 	(InvestigationEntity) response.getObj();
	}
	return null;
}

    // Real Method
// private Response oraItemName(Response response) {
//	 
//	 List <InvestigationEntity> investigationEntityList  = null;
//	 if(response.getItems() !=null) {
//		 investigationEntityList =  response.getItems();
//	 }
//  
//	  Connection con = null;
//	  ResultSet rs = null;
//	  Statement stm = null;
//	  List<OraInvestigationEntity> oraInvestigationEntityList = new ArrayList<OraInvestigationEntity>();
//      con = getOraConnection();
//      Long itemNo = null;
//      String customItemName = null;
//	try {
//		 stm  = con.createStatement();
//	     rs = stm.executeQuery(OraInvestigationStatement.oraItemStatement());
//	    
//	    while(rs.next()) {
//	    	
//	    	OraInvestigationEntity oraInvestigationEntity = new OraInvestigationEntity();
//	    	itemNo = rs.getLong("ITEM_NO");
//	    	oraInvestigationEntity.setItemNo(itemNo);
//	    	oraInvestigationEntity.setItemId(rs.getString("ITEM_ID"));
//	    	oraInvestigationEntity.setItemTypeNo(rs.getInt("ITEMTYPE_NO"));
//	 
//	    	
//	    	if(investigationEntityList  != null) {
//	    	   customItemName = matchInvestigateName(investigationEntityList,itemNo);
//	    		if( customItemName != null) {
//	    			oraInvestigationEntity.setItemCustomName(customItemName);
//	    		}
//	    	}
//	    	
//	    	
//	    	oraInvestigationEntity.setItemName(rs.getString("ITEM_NAME"));
//	    	oraInvestigationEntity.setDepartmentNo(rs.getLong("BU_NO"));
//	    	oraInvestigationEntity.setDepartmentName(rs.getString("BU_NAME"));
//	    	
//	    	oraInvestigationEntityList.add(oraInvestigationEntity);
//	    	
//	    }
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}finally {
//		 
//		finalyConStmRs(con,stm,rs);
//	}
//	
//	response.setItems(oraInvestigationEntityList);
//    
//    return getSuccessResponse("Itemd Found",response);
//
// }
 
 private String matchInvestigateName(List <InvestigationEntity> myItems, Long matchItemId) {
	 InvestigationEntity result = myItems.stream()                        
              .filter(myItem -> myItem.getIntegrateNo().longValue() == matchItemId)       
              .findAny()                                     
              .orElse(null);  
	 if(result != null) {
		return  result.getInvesCustomeName() ;
	 }
	 return null;
 }


@SuppressWarnings({ "rawtypes", "unchecked" })
private CriteriaQuery criteriaQuery(InvestigationEntity filter) {
	
	initEntityManagerBuilderCriteriaQueryRoot(InvestigationEntity.class);
	
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

		if (filter.getDoctorNo() != null &&  filter.getDoctorNo() > 0) {
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
