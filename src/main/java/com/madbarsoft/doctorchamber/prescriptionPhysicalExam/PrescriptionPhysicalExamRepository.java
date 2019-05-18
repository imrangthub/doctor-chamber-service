package com.madbarsoft.doctorchamber.prescriptionPhysicalExam;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
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
public class PrescriptionPhysicalExamRepository extends BaseRepository {

	public Response save(PrescriptionPhysicalExamEntity prescriptionPhysicalExam) {
		return baseOnlySave(prescriptionPhysicalExam);
	}

	public Response update(PrescriptionPhysicalExamEntity prescriptionPhysicalExam) {

		if (prescriptionPhysicalExam != null) {
			return baseUpdate(prescriptionPhysicalExam);
		}

		return getErrorResponse("Record not Found !!");
	}

	public Response detele(Long id) {

		PrescriptionPhysicalExamEntity prescriptionPhysicalExam = findById(id);
		return baseDelete(prescriptionPhysicalExam);

	}

	public Response remove(Long id) {
		PrescriptionPhysicalExamEntity prescriptionPhysicalExam = findById(id);
		prescriptionPhysicalExam.setActiveStatus(3);
		return baseRemove(prescriptionPhysicalExam);
	}

	public Response list() {
		return baseList(criteriaQuery(new PrescriptionPhysicalExamEntity()));
	}

	public PrescriptionPhysicalExamEntity findById(Long id) {
		PrescriptionPhysicalExamEntity prescriptionPhysicalExam = new PrescriptionPhysicalExamEntity();
		prescriptionPhysicalExam.setId(id);
		Response response = baseFindById(criteriaQuery(prescriptionPhysicalExam));

		if (response.isSuccess()) {
			return (PrescriptionPhysicalExamEntity) response.getObj();
		}
		return null;
	}

	public List<PrescriptionPhysicalExamEntity> getListFindByPrescriptionId(PrescriptionEntity id) {
		PrescriptionPhysicalExamEntity prescriptionPhysicalExam = new PrescriptionPhysicalExamEntity();
		prescriptionPhysicalExam.setPrescription(id);
		Response response = getListFindById(criteriaQuery(prescriptionPhysicalExam));

		if (response.isSuccess()) {
			return (List<PrescriptionPhysicalExamEntity>) response.getItems();
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private CriteriaQuery criteriaQuery(PrescriptionPhysicalExamEntity filter) {

		initEntityManagerBuilderCriteriaQueryRoot(PrescriptionPhysicalExamEntity.class);

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

			List<Order> orderList = new ArrayList();
			orderList.add(builder.asc(root.get("examGroup")));
			orderList.add(builder.asc(root.get("inReportSerial")));
			
			criteria.orderBy(orderList);

		}

		if (!CollectionUtils.isEmpty(p)) {
			Predicate[] pArray = p.toArray(new Predicate[] {});
			Predicate predicate = builder.and(pArray);
			criteria.where(predicate);
		}

		return criteria;

	}
}
