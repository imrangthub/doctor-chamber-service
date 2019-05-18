package com.madbarsoft.doctorchamber.prescriptionVital;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.madbarsoft.doctorchamber.base.BaseRepository;
import com.madbarsoft.doctorchamber.prescription.PrescriptionEntity;
import com.madbarsoft.doctorchamber.util.Response;
import com.madbarsoft.doctorchamber.vital.VitalEntity;
import com.madbarsoft.doctorchamber.vital.VitalService;

@Repository
@Transactional
public class PrescriptionVitalRepository extends BaseRepository {
	
	@Autowired
	VitalService vitalService;

	public Response save(PrescriptionVitalEntity prescriptionDetails) {
		return baseOnlySave(prescriptionDetails);
	}

	public Response update(PrescriptionVitalEntity prescriptionVital) {

		if (prescriptionVital != null) {
			return baseUpdate(prescriptionVital);
		}

		return getErrorResponse("Record not Found !!");
	}

	public Response detele(Long id) {

		PrescriptionVitalEntity prescriptionVital = findById(id);
		return baseDelete(prescriptionVital);

	}

	public Response remove(Long id) {
		PrescriptionVitalEntity prescriptionVital = findById(id);
		prescriptionVital.setActiveStatus(3);
		return baseRemove(prescriptionVital);
	}

	public Response list() {
		return baseList(criteriaQuery(new PrescriptionVitalEntity()));
	}

	public PrescriptionVitalEntity findById(Long id) {
		PrescriptionVitalEntity prescriptionVital = new PrescriptionVitalEntity();
		prescriptionVital.setId(id);
		Response response = baseFindById(criteriaQuery(prescriptionVital));

		if (response.isSuccess()) {
			return (PrescriptionVitalEntity) response.getObj();
		}
		return null;
	}

	public List<PrescriptionVitalEntity> getListFindByPrescriptionId(PrescriptionEntity id) {
		PrescriptionVitalEntity prescriptionVital = new PrescriptionVitalEntity();
		prescriptionVital.setPrescription(id);
		Response response = getListFindById(criteriaQuery(prescriptionVital));

		if (response.isSuccess()) {
			return (List<PrescriptionVitalEntity>) response.getItems();
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(PrescriptionVitalEntity filter) {

		initEntityManagerBuilderCriteriaQueryRoot(PrescriptionVitalEntity.class);

		CriteriaBuilder builder = super.builder;
		CriteriaQuery criteria = super.criteria;
		Root root = super.root;

		List<Predicate> p = new ArrayList<Predicate>();

		if (filter != null) {
			if (filter.getActiveStatus() > 0) {
				Predicate condition = builder.equal(root.get("activeStatus"), filter.getActiveStatus());
				p.add(condition);
			}

			if (filter.getId() != null && filter.getId() > 0) {
				Predicate condition = builder.equal(root.get("id"), filter.getId());
				p.add(condition);
			}

			if (filter.getPrescription() != null) {
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
	
	public List<PrescriptionVitalEntity> presVitalEntityListWithDoctorPreferenceOder(PrescriptionEntity id,Long doctorNo){
		List<PrescriptionVitalEntity> pvitalList = getListFindByPrescriptionId(id);

		if(pvitalList !=null) {
			VitalEntity vitalentity = new VitalEntity();
			vitalentity.setDoctorNo(doctorNo);
			Response responseVital = vitalService.list(vitalentity);
			if(responseVital.isSuccess() && responseVital.getItems()!=null) {
			List<VitalEntity> preferenceVitalList = getListFromObject(responseVital.getItems(), VitalEntity.class);
				List<PrescriptionVitalEntity> pvitalSortList = new ArrayList<PrescriptionVitalEntity>();
				PrescriptionVitalEntity pVitalSortEntity = null;
				for(VitalEntity serialVital : preferenceVitalList) {
				
					pVitalSortEntity = vitalSortingByDocotroPreference(pvitalList,serialVital.getVitalName());
				
				if(pVitalSortEntity !=null) {
					 pvitalSortList.add(pVitalSortEntity);
				 }
				
				}
				
				return pvitalSortList;
			}
			return pvitalList;
		}
		return null;
	}
	
	
	private PrescriptionVitalEntity vitalSortingByDocotroPreference(List<PrescriptionVitalEntity> presVitalList, String vitalName) {
		
		return presVitalList.stream().filter(preVital -> vitalName.equals(preVital.getVitalName()))
				.findAny().orElse(null);
	}
	
	
}




