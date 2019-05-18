package com.madbarsoft.doctorchamber.prescriptionDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.madbarsoft.doctorchamber.base.BaseRepository;
import com.madbarsoft.doctorchamber.prescription.PrescriptionEntity;
import com.madbarsoft.doctorchamber.util.Response;


@Repository
@Transactional
public class PrescriptionDetailsRepository extends BaseRepository {

	public Response save(PrescriptionDetailsEntity prescriptionDetails) {
		return baseOnlySave(prescriptionDetails);
	}

	public Response update(PrescriptionDetailsEntity prescriptionDetails) {
		
//		PrescriptionDetailsEntity obj = findById(prescriptionDetails.getId());
//
//		if (obj != null) {
//			obj.setModifiedDate(new Date());	
//			obj.setPrescritionData(prescriptionDetails.getPrescritionData());
//			return baseUpdate(obj);
//		}
		if (prescriptionDetails != null) {
			return baseUpdate(prescriptionDetails);
		}

		return getErrorResponse("Record not Found !!");
		}

	public Response detele(Long id) {

		PrescriptionDetailsEntity prescriptionDetails = findById(id);
		return baseDelete(prescriptionDetails);

	}

	public Response remove(Long id) {
		PrescriptionDetailsEntity prescriptionDetails = findById(id);
		prescriptionDetails.setActiveStatus(3);
		return baseRemove(prescriptionDetails);
	}

	public Response list() {

		return baseList(criteriaQuery(new PrescriptionDetailsEntity()));
	}

	public PrescriptionDetailsEntity findById(Long id) {
		PrescriptionDetailsEntity prescriptionDetails = new PrescriptionDetailsEntity();
		prescriptionDetails.setId(id);
		 Response response = baseFindById(criteriaQuery(prescriptionDetails));
		
		if (response.isSuccess()) {
			return (PrescriptionDetailsEntity) response.getObj();
		}
		return null;
	}
	
	public List<PrescriptionDetailsEntity> getListFindByPrescriptionId(PrescriptionEntity  id) {
		PrescriptionDetailsEntity prescriptionDetails = new PrescriptionDetailsEntity();
		prescriptionDetails.setPrescription(id);
		 Response response = getListFindById(criteriaQuery(prescriptionDetails));
		
		if (response.isSuccess()) {
			return getListFromObject(response.getItems(), PrescriptionDetailsEntity.class) ;
		}
		return null;
	}
	
	
   public  List<PrescriptionDetailsEntity> getDetailsListByDataType(List<PrescriptionDetailsEntity> presDetailList, int dataTypeid ){
	   List<PrescriptionDetailsEntity> pdList = presDetailList.stream().filter(pd -> pd.getPrescritionDataType() == dataTypeid).collect(Collectors.toList()); 
	   if(pdList !=null && pdList.size() > 0 ) {
		   return pdList;
	   }
	   return null;		  
	  }

	
  public   PrescriptionDetailsEntity getDetailsByDataType(List<PrescriptionDetailsEntity> presDetailList, int dataTypeid ){
		   
		  return presDetailList.stream().filter(pd -> pd.getPrescritionDataType() == dataTypeid).findFirst().orElse(null);     
	 }
  
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(PrescriptionDetailsEntity filter) {

		initEntityManagerBuilderCriteriaQueryRoot(PrescriptionDetailsEntity.class);
		
		CriteriaBuilder builder = super.builder; 
		CriteriaQuery criteria = super.criteria;
		Root root = super.root; 
		
		List<Predicate> p = new ArrayList<Predicate>();

	
		if (filter != null) {
			if (filter.getActiveStatus() > 0) {
				Predicate condition = builder.equal(root.get("activeStatus"), filter.getActiveStatus());
				p.add(condition);
			}

			if (filter.getId() !=null &&  filter.getId() > 0) {
				Predicate condition = builder.equal(root.get("id"), filter.getId());
				p.add(condition);
			}
			
			if (filter.getPrescription() !=null) {
				Predicate condition = builder.equal(root.get("prescription"), filter.getPrescription());
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
