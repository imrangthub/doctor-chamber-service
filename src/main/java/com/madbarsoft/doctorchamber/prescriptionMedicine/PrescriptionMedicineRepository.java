package com.madbarsoft.doctorchamber.prescriptionMedicine;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class PrescriptionMedicineRepository extends BaseRepository {

	public Response save(PrescriptionMedicineEntity prescriptionDetails) {
		return baseOnlySave(prescriptionDetails);
	}

	public Response update(PrescriptionMedicineEntity prescriptionDetails) {
		
//		PrescriptionMedicineEntity obj = findById(prescriptionDetails.getId());
//
//		if (obj != null) {
//			prescriptionDetails.setModifiedDate(new Date());
//			return baseUpdate(obj);
//		}
		if(prescriptionDetails != null) {
			return baseUpdate(prescriptionDetails);
		}
		
		return getErrorResponse("Record not Found !!");
		}

	public Response detele(Long id) {

		PrescriptionMedicineEntity prescriptionDetails = findById(id);
		return baseDelete(prescriptionDetails);

	}

	public Response remove(Long id) {
		PrescriptionMedicineEntity prescriptionDetails = findById(id);
		prescriptionDetails.setActiveStatus(3);
		return baseRemove(prescriptionDetails);
	}

	public Response list() {

		return baseList(criteriaQuery(new PrescriptionMedicineEntity()));
	}

	public PrescriptionMedicineEntity findById(Long id) {
		PrescriptionMedicineEntity prescriptionDetails = new PrescriptionMedicineEntity();
		prescriptionDetails.setId(id);
		 Response response = baseFindById(criteriaQuery(prescriptionDetails));
		
		if (response.isSuccess()) {
			return (PrescriptionMedicineEntity) response.getObj();
		}
		return null;
	}
	
	public List<PrescriptionMedicineEntity> getListFindByPrescriptionId(PrescriptionEntity  id) {
		PrescriptionMedicineEntity prescriptionMedicine = new PrescriptionMedicineEntity();
		prescriptionMedicine.setPrescription(id);
		 Response response = getListFindById(criteriaQuery(prescriptionMedicine));
		
		if (response.isSuccess()) {
			return (List<PrescriptionMedicineEntity>) response.getItems();
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(PrescriptionMedicineEntity filter) {

		initEntityManagerBuilderCriteriaQueryRoot(PrescriptionMedicineEntity.class);
		
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
			
			if (filter.getPrescription() !=null ) {
				Predicate condition = builder.equal(root.get("prescription"), filter.getPrescription());
				p.add(condition);
			}
			
			criteria.orderBy(builder.asc(root.get("inReportSerial")));

		}
		
		

		if (!CollectionUtils.isEmpty(p)) {
			Predicate[] pArray = p.toArray(new Predicate[] {});
			Predicate predicate = builder.and(pArray);
			criteria.where(predicate);
		}

		return criteria;

	}
}
