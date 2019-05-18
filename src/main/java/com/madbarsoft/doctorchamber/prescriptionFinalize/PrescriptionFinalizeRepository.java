package com.madbarsoft.doctorchamber.prescriptionFinalize;

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
import com.madbarsoft.doctorchamber.prescription.PrescriptionEntity;
import com.madbarsoft.doctorchamber.util.Response;


@Repository
@Transactional
public class PrescriptionFinalizeRepository extends BaseRepository {

	public Response save(PrescriptionFinalizeEntity prescriptionFinalizeEntity) {
		return baseOnlySave(prescriptionFinalizeEntity);
	}

	public Response update(PrescriptionFinalizeEntity prescriptionFinalizeEntity) {
		if (prescriptionFinalizeEntity != null) {
			return baseUpdate(prescriptionFinalizeEntity);
		}
		return getErrorResponse("Record not Found !!");
	}

	public Response detele(Long id) {
		PrescriptionFinalizeEntity prescriptionFinalizeEntity = findById(id);
		return baseDelete(prescriptionFinalizeEntity);

	}

	public Response remove(Long id) {
		PrescriptionFinalizeEntity prescriptionFinalizeEntity = findById(id);
		prescriptionFinalizeEntity.setActiveStatus(3);
		return baseRemove(prescriptionFinalizeEntity);
	}

	public Response list() {
		return baseList(criteriaQuery(new PrescriptionFinalizeEntity()));
	}

	public PrescriptionFinalizeEntity findById(Long id) {
		PrescriptionFinalizeEntity prescriptionFinalizeEntity = new PrescriptionFinalizeEntity();
		prescriptionFinalizeEntity.setId(id);
		Response response = baseFindById(criteriaQuery(prescriptionFinalizeEntity));
		if (response.isSuccess()) {
			return (PrescriptionFinalizeEntity) response.getObj();
		}
		return null;
	}

	public List<PrescriptionFinalizeEntity> getListFindByPrescriptionId(PrescriptionEntity id) {
		PrescriptionFinalizeEntity prescriptionFinalizeEntity = new PrescriptionFinalizeEntity();
		prescriptionFinalizeEntity.setPrescription(id);
		Response response = getListFindById(criteriaQuery(prescriptionFinalizeEntity));
		if (response.isSuccess()) {
			return (List<PrescriptionFinalizeEntity>) response.getItems();
		}
		return null;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(PrescriptionFinalizeEntity filter) {
		initEntityManagerBuilderCriteriaQueryRoot(PrescriptionFinalizeEntity.class);
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
